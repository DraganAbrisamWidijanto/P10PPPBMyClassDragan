package com.example.p10papbmyclassdragan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.p10papbmyclassdragan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur judul aktivitas menjadi "My Class"
        title = "My Class"

        // Menggunakan view binding untuk menghubungkan layout XML dengan aktivitas
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Membuat adapter untuk daftar siswa dengan memanggil fungsi generateStudent()
        val adapterStudent = StudentAdapter(generateStudent()) { student ->
            // Menampilkan toast dengan nama siswa saat item di klik
            Toast.makeText(this, student.name, Toast.LENGTH_SHORT).show()

            // Membuat intent untuk membuka StudentActivity dan mengirim data siswa
            val intent = Intent(this, StudentActivity::class.java)
            intent.putExtra("name", student.name)
            intent.putExtra("gpa", student.gpa)
            intent.putExtra("aboutMe", student.aboutMe)
            intent.putExtra("profileImage", student.profileImage) // Mengirim data gambar profil siswa
            intent.putExtra("bannerImage", student.bannerImage) // Mengirim data gambar banner siswa
            startActivity(intent) // Memulai aktivitas StudentActivity
        }

        // Mengatur adapter dan layout manager untuk RecyclerView di dalam binding.rvStudent
        with(binding) {
            rvStudent.apply {
                adapter = adapterStudent
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun generateStudent(): List<Student> {
        return listOf(
            // Menyediakan data siswa dengan nama, nilai GPA, dan deskripsi tentang siswa
           //default
            Student(name ="Beliau", gpa =3.91, aboutMe = getString(R.string.lorem)),
            //menggunakan link gambar
            Student(
                name ="Jotaro", gpa =3.51, aboutMe = getString(R.string.lorem),
                profileImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/fot1.jpg?raw=true",
                bannerImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/poto1.jpg?raw=true"),
            Student(
                name ="Rayquaza", gpa =1.2, aboutMe = getString(R.string.lorem),
                profileImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/fot2.jpg?raw=true",
                bannerImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/poto2.jpg?raw=true"),
            Student(
                name ="Freya", gpa =2.81, aboutMe = getString(R.string.lorem),
                profileImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/fot3.jpg?raw=true",
                bannerImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/poto3.jpg?raw=true"),

            //ulangi data
            Student(name ="Beliau", gpa =3.91, aboutMe = getString(R.string.lorem)),
            Student(
                name ="Jotaro", gpa =3.51, aboutMe = getString(R.string.lorem),
                profileImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/fot1.jpg?raw=true",
                bannerImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/poto1.jpg?raw=true"),
            Student(
                name ="Rayquaza", gpa =1.2, aboutMe = getString(R.string.lorem),
                profileImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/fot2.jpg?raw=true",
                bannerImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/poto2.jpg?raw=true"),
            Student(
                name ="Freya", gpa =2.81, aboutMe = getString(R.string.lorem),
                profileImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/fot3.jpg?raw=true",
                bannerImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/poto3.jpg?raw=true"),

            //ulangi data
            Student(name ="Beliau", gpa =3.91, aboutMe = getString(R.string.lorem)),
            Student(
                name ="Jotaro", gpa =3.51, aboutMe = getString(R.string.lorem),
                profileImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/fot1.jpg?raw=true",
                bannerImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/poto1.jpg?raw=true"),
            Student(
                name ="Rayquaza", gpa =1.2, aboutMe = getString(R.string.lorem),
                profileImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/fot2.jpg?raw=true",
                bannerImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/poto2.jpg?raw=true"),
            Student(
                name ="Freya", gpa =2.81, aboutMe = getString(R.string.lorem),
                profileImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/fot3.jpg?raw=true",
                bannerImage = "https://github.com/DraganAbrisamWidijanto/imgdatamyclass/blob/main/poto3.jpg?raw=true"),
        )
    }
}
