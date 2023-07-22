package com.example.billsapp


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.billsapp.databinding.ActivityRegistrationBinding
import model.RegisterRequest
import viewmodel.UserViewmodel

class Registration : AppCompatActivity() {

    private val userViewModel: UserViewmodel by viewModels()
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            validateSignUp()
        }


        binding.btnLog.setOnClickListener {
            val intent = Intent(this, com.example.billsapp. Login::class.java)
            startActivity(intent)
        }

        fun saveRegistrationData(email: String, password: String) {
            val sharedPreferences: SharedPreferences =
                getSharedPreferences("RegistrationData", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("email", email)
            editor.putString("password", password)
            editor.apply()
        }

    }

    private fun validateSignUp() {
        val firstname = binding.etFirstName.text.toString().trim()
        val lastname = binding.etLastName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val phone = binding.etPhone.text.toString().trim()
        val password = binding.etpassword.text.toString()
        val confirm = binding.etConfirm.text.toString()
        var error = false

        if (firstname.isBlank()) {
            binding.tilFirstName.error = "First name is required"
            error = true
        } else {
            binding.tilFirstName.error = null
        }

        if (lastname.isBlank()) {
            binding.tilLastName.error = "Last name is required"
            error = true
        } else {
            binding.tilLastName.error = null
        }

        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        } else {
            binding.tilEmail.error = null
        }

        if (phone.isBlank()) {
            binding.tilPhoneNumber.error = "Contact is required"
            error = true
        } else {
            binding.tilPhoneNumber.error = null
        }

        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        } else {
            binding.tilPassword.error = null
        }

        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Confirm password is required"
            error = true
        } else if (confirm != password) {
            binding.tilConfirm.error = "Passwords do not match"
            error = true
        } else {
            binding.tilConfirm.error = null
        }

        if (!error) {
            val registerRequest = RegisterRequest(
                firstName = firstname,
                lastName = lastname,
                email = email,
                userId= " ",
                phoneNumber = phone,
            )
            binding.btnRegister.visibility = View.VISIBLE
            userViewModel.registerUser(registerRequest)


            saveRegistrationData(email, password)
        }
    }

    private fun saveRegistrationData(email: String, password: String) {
        TODO("Not yet implemented")
    }
}


