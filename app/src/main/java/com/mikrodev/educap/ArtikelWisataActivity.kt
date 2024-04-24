//package com.mikrodev.educap
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//
//class ArtikelWisataActivity : AppCompatActivity(), View.OnClickListener {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_artikel_wisata)
//
//        val btnProfil : View = findViewById(R.id.profil)
//        btnProfil.setOnClickListener(this)
//        val btnHome : View = findViewById(R.id.home)
//        btnHome.setOnClickListener(this)
//        val btnBudaya : View = findViewById(R.id.Budaya)
//        btnBudaya.setOnClickListener(this)
//    }
//
//    override fun onClick(v: View?) {
//        if(v != null) {
//            when(v.id) {
//                R.id.profil -> {
//                    val swipeProfil = Intent(this, ProfileActivity::class.java)
//                    startActivity(swipeProfil)
//                }
//                R.id.home -> {
//                    val swipeHome = Intent(this, HomeScreenActivity::class.java)
//                    startActivity(swipeHome)
//                }
//                R.id.Budaya -> {
//                    val swipeBudaya = Intent(this, ArtikelBudayaActivity::class.java)
//                    startActivity(swipeBudaya)
//                }
//            }
//        }
//    }
//}