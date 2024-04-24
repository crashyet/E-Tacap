package com.mikrodev.educap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ArtikelBudayaActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel_budaya)

        val btnProfil : View = findViewById(R.id.profil)
        btnProfil.setOnClickListener(this)
        val btnHome : View = findViewById(R.id.home)
        btnHome.setOnClickListener(this)
        val btnBudaya : View = findViewById(R.id.btnBudaya1)
        btnBudaya.setOnClickListener(this)
        val btnWisata : View = findViewById(R.id.btnBudaya2)
        btnWisata.setOnClickListener(this)


//        val btnWisata : View = findViewById(R.id.Wisata)
//        btnWisata.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v != null) {
            when(v.id) {
                R.id.profil -> {
                    Toast.makeText(this, "Mohon maaf menu profil belum bisa di gunakan", Toast.LENGTH_SHORT).show()
//                    val swipeProfil = Intent(this, ProfileActivity::class.java)
//                    startActivity(swipeProfil)
                }
                R.id.home -> {
                    val swipeHome = Intent(this, HomeScreenActivity::class.java)
                    startActivity(swipeHome)
                }

                //swipe to budaya
                R.id.btnBudaya1 -> {
                    val artikel = Intent(this, PdfBudayaActivity::class.java)
                    startActivity(artikel)
                }

                //swipe to wisata
                R.id.btnBudaya2 -> {
                    val artikel = Intent(this, PdfWisataActivity::class.java)
                    startActivity(artikel)
                }




//                R.id.Wisata -> {
//                    val swipeWisata = Intent(this, ArtikelWisataActivity::class.java)
//                    startActivity(swipeWisata)
//                }
            }
        }
    }
}