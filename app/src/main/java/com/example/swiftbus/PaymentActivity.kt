package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val busName = intent.getStringExtra("busName") ?: ""
        val selectedSeats = intent.getStringExtra("selectedSeats") ?: ""
        val totalAmount = intent.getIntExtra("totalAmount", 0)

        val totalAmountTextView = findViewById<TextView>(R.id.tvTotalAmount)
        val payNowButton = findViewById<Button>(R.id.btnPayNow)

        totalAmountTextView.text = "\$${totalAmount}"

        payNowButton.setOnClickListener {
            // Simulate payment processing
            val intent = Intent(this, TicketConfirmationActivity::class.java)
            intent.putExtra("busName", busName)
            intent.putExtra("selectedSeats", selectedSeats)
            intent.putExtra("totalAmount", totalAmount)
            intent.putExtra("ticketNumber", "SW${System.currentTimeMillis().toString().takeLast(8)}")
            startActivity(intent)
            finishAffinity()
        }
    }
}