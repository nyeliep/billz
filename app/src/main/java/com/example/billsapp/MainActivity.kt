package com.example.billsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import com.example.billsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
