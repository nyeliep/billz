package com.example.billsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.billsapp.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            validateLogin()
        }
    }

    private fun validateLogin() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etpassword.text.toString()

        if (username.isBlank()) {
            binding.etUsername.error = "username is required"
            return
        }


        if (password.isBlank()) {
            binding.etpassword.error = "Password is required"
            return
        }



        Toast.makeText(this, "com.example.billsapp.Login successful", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, Home::class.java)
        startActivity(intent)
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
