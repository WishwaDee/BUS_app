package com.example.swiftbus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout

class SeatSelectionActivity : AppCompatActivity() {

    private val selectedSeats = mutableListOf<String>()
    private lateinit var selectedCountTextView: TextView
    private lateinit var totalAmountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val busName = intent.getStringExtra("busName") ?: "Unknown Bus"
        val busPrice = intent.getStringExtra("busPrice")?.replace("$", "")?.toIntOrNull() ?: 0

        selectedCountTextView = findViewById(R.id.tvSelectedCount)
        totalAmountTextView = findViewById(R.id.tvTotalAmount)
        val continueButton = findViewById<Button>(R.id.btnContinue)

        setupSeatGrid(busPrice)

        continueButton.setOnClickListener {
            if (selectedSeats.isNotEmpty()) {
                val intent = Intent(this, BookingSummaryActivity::class.java)
                intent.putExtra("busName", busName)
                intent.putExtra("selectedSeats", selectedSeats.joinToString(", "))
                intent.putExtra("totalAmount", selectedSeats.size * busPrice)
                startActivity(intent)
            }
        }
    }

    private fun setupSeatGrid(seatPrice: Int) {
        val seatGrid = findViewById<GridLayout>(R.id.seatGrid)
        
        // Create seat layout (40 seats: 10 rows x 4 seats)
        for (row in 1..10) {
            for (col in listOf('A', 'B', 'C', 'D')) {
                val seatNumber = "$row$col"
                val seatButton = Button(this)
                
                seatButton.text = seatNumber
                seatButton.layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    setMargins(8, 8, 8, 8)
                }
                
                seatButton.setBackgroundResource(R.drawable.seat_background)
                
                // Random booked seats for demo
                val isBooked = (seatNumber.hashCode() % 10) < 2
                if (isBooked) {
                    seatButton.isEnabled = false
                }
                
                seatButton.setOnClickListener {
                    if (seatButton.isSelected) {
                        seatButton.isSelected = false
                        selectedSeats.remove(seatNumber)
                    } else {
                        seatButton.isSelected = true
                        selectedSeats.add(seatNumber)
                    }
                    updateSelection(seatPrice)
                }
                
                seatGrid.addView(seatButton)
            }
        }
    }

    private fun updateSelection(seatPrice: Int) {
        selectedCountTextView.text = "${selectedSeats.size} seat(s) selected"
        totalAmountTextView.text = "\$${selectedSeats.size * seatPrice}"
    }
}