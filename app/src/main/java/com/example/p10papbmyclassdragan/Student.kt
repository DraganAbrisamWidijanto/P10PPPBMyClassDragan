package com.example.p10papbmyclassdragan

data class Student(
    var name: String = "",
    var gpa: Double = 0.0,
    var aboutMe: String = "",

    var profileImage: String = "",
    var bannerImage: String = "",
    var profileImageDefault: Int = R.drawable.morebullet,
    var bannerImageDefault: Int = R.drawable.banner1
)
