package com.mikrodev.educap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        textName = findViewById(R.id.textView18)
        val username = intent.getStringExtra("username")
        textName.text = username

        val btnArtikel : View = findViewById(R.id.artikel)
        btnArtikel.setOnClickListener(this)
        val btnHome : View = findViewById(R.id.home)
        btnHome.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.artikel -> {
                    val swipeArtikel = Intent(this, ArtikelBudayaActivity::class.java)
                    startActivity(swipeArtikel)
                }
                R.id.home -> {
                    val swipeHome = Intent(this, HomeScreenActivity::class.java)
                    startActivity(swipeHome)
                }
            }
        }
    }
}