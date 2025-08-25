package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BusDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_details)

        val busName = intent.getStringExtra("busName") ?: "Unknown Bus"
        val busPrice = intent.getStringExtra("busPrice") ?: "$0"

        val busNameTextView = findViewById<TextView>(R.id.tvBusName)
        val busPriceTextView = findViewById<TextView>(R.id.tvBusPrice)
        val selectSeatsButton = findViewById<Button>(R.id.btnSelectSeats)

        busNameTextView.text = busName
        busPriceTextView.text = busPrice

        selectSeatsButton.setOnClickListener {
            val intent = Intent(this, SeatSelectionActivity::class.java)
            intent.putExtra("busName", busName)
            intent.putExtra("busPrice", busPrice)
            startActivity(intent)
        }
    }
}