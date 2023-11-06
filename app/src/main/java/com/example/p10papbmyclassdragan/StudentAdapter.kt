package com.example.p10papbmyclassdragan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.p10papbmyclassdragan.databinding.ItemStudentBinding

// Tipe data yang mewakili fungsi klik siswa
typealias OnClickStudent = (Student) -> Unit

// Kelas adapter untuk RecyclerView, menghubungkan data siswa dengan tampilan item siswa di RecyclerView
class StudentAdapter(private val studentList: List<Student>, val onClickStudent: OnClickStudent)
    : RecyclerView.Adapter<StudentAdapter.ItemStudentViewHolder>() {

    // Kelas inner ViewHolder untuk menangani tata letak item siswa di RecyclerView
    inner class ItemStudentViewHolder(private val binding: ItemStudentBinding): RecyclerView.ViewHolder(binding.root) {
        // Fungsi untuk mengikat data siswa ke tata letak item siswa
        fun bind(student: Student) {
            with(binding) {
                // Menetapkan nama siswa ke teks view
                txtstudentName.text = student.name

                // Memeriksa dan menetapkan gambar profil siswa menggunakan Glide
                if(student.profileImage != "") {
                    putIconImage(student.profileImage)
                } else {
                    // Menetapkan gambar default jika tidak ada gambar profil siswa
                    studentImage.setImageResource(student.profileImageDefault)
                }

                // Memeriksa nilai GPA dan menetapkan warna status siswa
                checkGPA(student.gpa)

                // Menambahkan tindakan klik ke item siswa
                itemView.setOnClickListener { onClickStudent(student) }
            }
        }

        // Fungsi untuk memeriksa nilai GPA dan menetapkan warna status siswa
        fun checkGPA(gpa: Double) {
            if (gpa >= 3.5) {
                binding.statuscolor.setImageResource(R.color.green)
                binding.txtstudentName.setTextColor(ContextCompat.getColor(itemView.context, R.color.green))
            } else if (gpa >= 2.0) {
                binding.statuscolor.setImageResource(R.color.blue)
                binding.txtstudentName.setTextColor(ContextCompat.getColor(itemView.context, R.color.blue))
            } else {
                binding.statuscolor.setImageResource(R.color.grey)
                binding.txtstudentName.setTextColor(ContextCompat.getColor(itemView.context, R.color.grey))
            }
        }

        // Fungsi untuk menampilkan gambar profil siswa menggunakan Glide
        fun putIconImage(image: String) {
            Glide.with(itemView.context)
                .load(image)
                .into(binding.studentImage)
        }
    }

    // Metode yang dipanggil saat ViewHolder baru dibuat
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHolder {
        // Membuat ViewHolder baru menggunakan ItemStudentBinding
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemStudentViewHolder(binding)
    }

    // Metode untuk mendapatkan jumlah total item siswa dalam RecyclerView
    override fun getItemCount(): Int {
        return studentList.size
    }

    // Metode untuk mengikat data siswa ke ViewHolder
    override fun onBindViewHolder(holder: ItemStudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }
}
