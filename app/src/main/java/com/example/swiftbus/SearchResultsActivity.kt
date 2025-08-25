package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class SearchResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)

        val from = intent.getStringExtra("from") ?: ""
        val to = intent.getStringExtra("to") ?: ""
        val date = intent.getStringExtra("date") ?: ""

        // Sample bus cards
        val bus1Card = findViewById<CardView>(R.id.cardBus1)
        val bus2Card = findViewById<CardView>(R.id.cardBus2)
        val bus3Card = findViewById<CardView>(R.id.cardBus3)

        bus1Card.setOnClickListener {
            val intent = Intent(this, BusDetailsActivity::class.java)
            intent.putExtra("busName", "Swift Express")
            intent.putExtra("busPrice", "\$45")
            startActivity(intent)
        }

        bus2Card.setOnClickListener {
            val intent = Intent(this, BusDetailsActivity::class.java)
            intent.putExtra("busName", "Comfort Travels")
            intent.putExtra("busPrice", "\$38")
            startActivity(intent)
        }

        bus3Card.setOnClickListener {
            val intent = Intent(this, BusDetailsActivity::class.java)
            intent.putExtra("busName", "Royal Rides")
            intent.putExtra("busPrice", "\$52")
            startActivity(intent)
        }
    }
}