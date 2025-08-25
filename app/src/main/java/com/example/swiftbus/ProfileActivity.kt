package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val myTripsSection = findViewById<LinearLayout>(R.id.llMyTrips)
        val paymentMethodsSection = findViewById<LinearLayout>(R.id.llPaymentMethods)
        val notificationsSection = findViewById<LinearLayout>(R.id.llNotifications)
        val helpSupportSection = findViewById<LinearLayout>(R.id.llHelpSupport)
        val aboutUsSection = findViewById<LinearLayout>(R.id.llAboutUs)
        val logoutSection = findViewById<LinearLayout>(R.id.llLogout)

        myTripsSection.setOnClickListener {
            startActivity(Intent(this, MyBookingsActivity::class.java))
        }

        paymentMethodsSection.setOnClickListener {
            // Navigate to Payment Methods
        }

        notificationsSection.setOnClickListener {
            // Navigate to Notifications Settings
        }

        helpSupportSection.setOnClickListener {
            // Navigate to Help & Support
        }

        aboutUsSection.setOnClickListener {
            // Navigate to About Us
        }

        logoutSection.setOnClickListener {
            // Logout and go to login screen
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()
        }
    }
}