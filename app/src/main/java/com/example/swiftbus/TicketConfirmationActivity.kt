package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TicketConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_confirmation)

        val busName = intent.getStringExtra("busName") ?: ""
        val selectedSeats = intent.getStringExtra("selectedSeats") ?: ""
        val totalAmount = intent.getIntExtra("totalAmount", 0)
        val ticketNumber = intent.getStringExtra("ticketNumber") ?: ""

        val ticketNumberTextView = findViewById<TextView>(R.id.tvTicketNumber)
        val busNameTextView = findViewById<TextView>(R.id.tvBusName)
        val seatsTextView = findViewById<TextView>(R.id.tvSeats)
        val amountTextView = findViewById<TextView>(R.id.tvAmount)
        val viewBookingsButton = findViewById<Button>(R.id.btnViewBookings)
        val downloadTicketButton = findViewById<Button>(R.id.btnDownloadTicket)

        ticketNumberTextView.text = ticketNumber
        busNameTextView.text = busName
        seatsTextView.text = selectedSeats
        amountTextView.text = "$$totalAmount"

        viewBookingsButton.setOnClickListener {
            startActivity(Intent(this, MyBookingsActivity::class.java))
            finishAffinity()
        }

        downloadTicketButton.setOnClickListener {
            // Simulate download
            // In real app, would generate PDF or show download dialog
        }
    }
}