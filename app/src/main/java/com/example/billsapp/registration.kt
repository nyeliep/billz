package com.example.billsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billsapp.databinding.ActivityMainBinding

class registration : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            startActivity(Intent(this, registration::class.java))
        }

        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }
    }
}