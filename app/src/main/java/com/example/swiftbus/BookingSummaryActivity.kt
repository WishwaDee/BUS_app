package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookingSummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_summary)

        val busName = intent.getStringExtra("busName") ?: ""
        val selectedSeats = intent.getStringExtra("selectedSeats") ?: ""
        val totalAmount = intent.getIntExtra("totalAmount", 0)

        val busNameTextView = findViewById<TextView>(R.id.tvBusName)
        val selectedSeatsTextView = findViewById<TextView>(R.id.tvSelectedSeats)
        val baseFareTextView = findViewById<TextView>(R.id.tvBaseFare)
        val taxesTextView = findViewById<TextView>(R.id.tvTaxes)
        val totalFareTextView = findViewById<TextView>(R.id.tvTotalFare)
        val proceedButton = findViewById<Button>(R.id.btnProceedPayment)

        val taxes = (totalAmount * 0.12).toInt()
        val finalAmount = totalAmount + taxes

        busNameTextView.text = busName
        selectedSeatsTextView.text = "Seats: $selectedSeats"
        baseFareTextView.text = "$$totalAmount"
        taxesTextView.text = "$$taxes"
        totalFareTextView.text = "$$finalAmount"

        proceedButton.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("busName", busName)
            intent.putExtra("selectedSeats", selectedSeats)
            intent.putExtra("totalAmount", finalAmount)
            startActivity(intent)
        }
    }
}