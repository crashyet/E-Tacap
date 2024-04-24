package com.mikrodev.educap

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeScreenActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val btnArtikel : View = findViewById(R.id.artikel)
        btnArtikel.setOnClickListener(this)
        val btnProfil : View = findViewById(R.id.profil)
        btnProfil.setOnClickListener(this)


        //game
        val puzzle : View = findViewById(R.id.game_puzzle)
        puzzle.setOnClickListener(this)
        val quis : View = findViewById(R.id.game_quiz)
        quis.setOnClickListener(this)
        val word : View = findViewById(R.id.game_word)
        word.setOnClickListener(this)


        //video
        val gnSelok : View = findViewById(R.id.btn_vid1)      //Gunung Selok
        val cmrSewu : View = findViewById(R.id.btn_vid2)      //Cemara Sewu
        val ptBunton : View = findViewById(R.id.btn_vid3)     //Pantai Bunton
        val ptSodong : View = findViewById(R.id.btn_vid4)     //Pantai Sodong
        val telukPenyu : View = findViewById(R.id.btn_vid5)   //Teluk Penyu
        val btPendem : View = findViewById(R.id.btn_vid6)     //Benteng Pendem
        val kabAlun : View = findViewById(R.id.btn_vid7)      //Alun Alun

        gnSelok.setOnClickListener {
            val url = "https://youtu.be/MZ2_BZOvM2g?feature=shared"

            // Membuat Intent untuk membuka URL di browser
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        cmrSewu.setOnClickListener {
            val url = "https://youtu.be/MZ2_BZOvM2g?feature=shared"

            // Membuat Intent untuk membuka URL di browser
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        ptBunton.setOnClickListener {
            val url = "https://youtu.be/Oz2b0303fYg?si=3h-N1VLvSNSpJCTc"

            // Membuat Intent untuk membuka URL di browser
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        ptSodong.setOnClickListener {
            val url = "https://youtu.be/XfqvN66r81o?si=7ay69JfLpzhj7DXc"

            // Membuat Intent untuk membuka URL di browser
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        telukPenyu.setOnClickListener {
            val url = "https://youtu.be/uir0kCQSw_c?si=hQ7Fef5ZNIGMYk79"

            // Membuat Intent untuk membuka URL di browser
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        btPendem.setOnClickListener {
            val url = "https://youtu.be/qaM6ITcUyOw?si=TnzyDPftH9o01D6k"

            // Membuat Intent untuk membuka URL di browser
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        kabAlun.setOnClickListener {
            val url = "https://youtu.be/rrFkZ56y50Y?si=Iq3xS95phQiL7Vta"

            // Membuat Intent untuk membuka URL di browser
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

    }


    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.artikel -> {
                    val swipeArtikel = Intent(this, ArtikelBudayaActivity::class.java)
                    startActivity(swipeArtikel)
                }
                R.id.profil -> {
                    Toast.makeText(this, "Mohon maaf menu profil belum bisa di gunakan", Toast.LENGTH_SHORT).show()
//                    val swipeProfil = Intent(this, ProfileActivity::class.java)
//                    startActivity(swipeProfil)
                }

                //game
                R.id.game_puzzle -> {
                    val game = Intent(this, PuzzleActivity::class.java)
                    startActivity(game)
                }
                R.id.game_quiz -> {
                    val sback = Intent(applicationContext, MainActivity::class.java)
                    startActivity(sback)
                }
                R.id.game_word -> {
                    Toast.makeText(this, "Mohon maaf game ini belum bisa di mainkan", Toast.LENGTH_SHORT).show()
//                    val game = Intent(this, ProfileActivity::class.java)
//                    startActivity(game)
                }

            }
        }
    }
}