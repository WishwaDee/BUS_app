package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fromEditText = findViewById<TextInputEditText>(R.id.etFrom)
        val toEditText = findViewById<TextInputEditText>(R.id.etTo)
        val dateEditText = findViewById<TextInputEditText>(R.id.etDate)
        val searchButton = findViewById<Button>(R.id.btnSearch)
        val profileIcon = findViewById<ImageView>(R.id.ivProfile)
        val bookingsIcon = findViewById<ImageView>(R.id.ivBookings)

        // Popular routes
        val route1Card = findViewById<CardView>(R.id.cardRoute1)
        val route2Card = findViewById<CardView>(R.id.cardRoute2)
        val route3Card = findViewById<CardView>(R.id.cardRoute3)

        searchButton.setOnClickListener {
            val from = fromEditText.text.toString()
            val to = toEditText.text.toString()
            val date = dateEditText.text.toString()

            if (from.isNotEmpty() && to.isNotEmpty() && date.isNotEmpty()) {
                val intent = Intent(this, SearchResultsActivity::class.java)
                intent.putExtra("from", from)
                intent.putExtra("to", to)
                intent.putExtra("date", date)
                startActivity(intent)
            }
        }

        profileIcon.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        bookingsIcon.setOnClickListener {
            startActivity(Intent(this, MyBookingsActivity::class.java))
        }

        route1Card.setOnClickListener {
            fromEditText.setText("New York")
            toEditText.setText("Boston")
        }

        route2Card.setOnClickListener {
            fromEditText.setText("Los Angeles")
            toEditText.setText("San Francisco")
        }

        route3Card.setOnClickListener {
            fromEditText.setText("Chicago")
            toEditText.setText("Detroit")
        }
    }
}