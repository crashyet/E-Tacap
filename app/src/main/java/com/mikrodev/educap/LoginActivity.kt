package com.mikrodev.educap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mikrodev.educap.databinding.ActivityLoginBinding

//class LoginActivity : AppCompatActivity(), View.OnClickListener {
class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        setContentView(R.layout.activity_login)
//        val btnLogin : Button = findViewById(R.id.btn_Login)
//        btnLogin.setOnClickListener(this)

        auth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            val email = binding.logEmail.text.toString()
            val password = binding.logPass.text.toString()

            if (email.isEmpty()) {
                binding.logEmail.error = "Email harus diisi!"
                binding.logEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.logEmail.error = "Email tidak valid!"
                binding.logEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.logPass.error = "Password harus diisi!"
                binding.logPass.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful) {
                    Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeScreenActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

//    override fun onClick(v: View?) {
//        if (v != null) {
//            when(v.id) {
//                R.id.btn_Login -> {
//                    val nextPage = Intent(this, HomeScreenActivity::class.java)
//                    startActivity(nextPage)
//                }
//            }
//        }
//    }
}