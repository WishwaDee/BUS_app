package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Onboarding2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding2)

        val nextButton = findViewById<Button>(R.id.btnNext)
        val skipButton = findViewById<TextView>(R.id.tvSkip)

        nextButton.setOnClickListener {
            startActivity(Intent(this, Onboarding3Activity::class.java))
        }

        skipButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()
        }
    }
}