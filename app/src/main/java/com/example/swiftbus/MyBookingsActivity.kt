package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MyBookingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_bookings)

        // Sample booking cards - in real app would load from database
        val booking1Card = findViewById<CardView>(R.id.cardBooking1)
        val booking2Card = findViewById<CardView>(R.id.cardBooking2)

        booking1Card.setOnClickListener {
            // Show ticket details
        }

        booking2Card.setOnClickListener {
            // Show ticket details
        }
    }
}