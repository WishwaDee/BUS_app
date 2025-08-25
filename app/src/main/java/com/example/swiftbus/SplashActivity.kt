package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Navigate to onboarding after delay
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Onboarding1Activity::class.java))
            finish()
        }, SPLASH_DELAY)
    }
}