package com.mikrodev.educap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeLoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_login)

        val btnLogin : Button = findViewById(R.id.btnLogin)
        val btnSignup : Button = findViewById(R.id.btnSignup)
        btnLogin.setOnClickListener(this)
        btnSignup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v != null){
            when(v.id){
                R.id.btnLogin -> {
                    val nextPage = Intent(this, LoginActivity::class.java)
                    startActivity(nextPage)
                }

                R.id.btnSignup -> {
                    val nextPage = Intent(this, SignupActivity::class.java)
                    startActivity(nextPage)
                }
            }
        }
    }
}