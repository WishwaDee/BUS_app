package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val fullNameEditText = findViewById<TextInputEditText>(R.id.etFullName)
        val emailEditText = findViewById<TextInputEditText>(R.id.etEmail)
        val phoneEditText = findViewById<TextInputEditText>(R.id.etPhone)
        val passwordEditText = findViewById<TextInputEditText>(R.id.etPassword)
        val confirmPasswordEditText = findViewById<TextInputEditText>(R.id.etConfirmPassword)
        val signupButton = findViewById<Button>(R.id.btnSignup)
        val loginLink = findViewById<TextView>(R.id.tvLoginLink)

        signupButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || 
                password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
            } else {
                // Dummy signup - always success
                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                finishAffinity()
            }
        }

        loginLink.setOnClickListener {
            finish()
        }
    }
}