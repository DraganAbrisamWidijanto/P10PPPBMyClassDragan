package com.example.p10papbmyclassdragan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.p10papbmyclassdragan.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan view binding untuk menghubungkan layout XML dengan aktivitas
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data siswa yang dikirim melalui intent
        val name = intent.getStringExtra("name")
        val aboutMe = intent.getStringExtra("aboutMe")
        val gpa = intent.getDoubleExtra("gpa", 0.0)
        val profileImage = intent.getStringExtra("profileImage")
        val bannerImage = intent.getStringExtra("bannerImage")

        // Menampilkan data siswa di tata letak activity_student.xml menggunakan view binding
        with(binding) {
            textname.text = name
            textAboutmeDesc.text = aboutMe
            textstatus.text = "GPA: $gpa" // Menampilkan nilai GPA

            // Memeriksa dan menetapkan warna status berdasarkan nilai GPA
            checkGPA(gpa)

            // Memeriksa dan menampilkan gambar profil siswa jika tersedia
            if (profileImage != null && profileImage.isNotEmpty()) {
                putIconImage(profileImage)
            }

            // Memeriksa dan menampilkan gambar banner siswa jika tersedia
            if (bannerImage != null && bannerImage.isNotEmpty()) {
                putBannerImage(bannerImage)
            }

            // Menambahkan tindakan klik untuk tombol panah kembali
            arrowback.setOnClickListener {
                finish() // Menutup aktivitas saat tombol panah kembali ditekan
            }
        }
    }

    // Fungsi untuk memeriksa nilai GPA dan menetapkan warna status
    private fun checkGPA(gpa: Double) {
        when {
            gpa >= 3.5 -> {
                binding.circleImageViewstatus.setImageResource(R.color.green)
                binding.textname.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
            gpa >= 2.75 -> {
                binding.circleImageViewstatus.setImageResource(R.color.blue)
                binding.textname.setTextColor(ContextCompat.getColor(this, R.color.blue))
            }
            else -> {
                binding.circleImageViewstatus.setImageResource(R.color.grey)
                binding.textname.setTextColor(ContextCompat.getColor(this, R.color.grey))
            }
        }
    }

    // Fungsi untuk menampilkan gambar profil siswa menggunakan Glide
    private fun putIconImage(image: String) {
        Glide.with(this)
            .load(image)
            .into(binding.profileImage)
    }

    // Fungsi untuk menampilkan gambar banner siswa menggunakan Glide
    private fun putBannerImage(image: String) {
        Glide.with(this)
            .load(image)
            .into(binding.gambarBanner)
    }
}
