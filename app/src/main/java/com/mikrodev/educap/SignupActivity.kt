package com.mikrodev.educap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.mikrodev.educap.databinding.ActivitySignupBinding
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.btnSignUp.setOnClickListener{
            val email = binding.email.text.toString()
            val password = binding.pass.text.toString()


            if (email.isEmpty()) {
                binding.email.error = "Email harus diisi!"
                binding.email.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.email.error = "Email tidak valid!"
                    binding.email.requestFocus()
                    return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.pass.error = "Password harus diisi!"
                binding.pass.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6) {
                binding.pass.error = "Password minimal 6 karakter"
                binding.pass.requestFocus()
                return@setOnClickListener
            }

            SignupFirebase(email,password)
        }
    }

    private fun SignupFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password,)
            .addOnCompleteListener(this){
                if (it.isSuccessful) {
                    Toast.makeText(this, "Register berhasil!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
