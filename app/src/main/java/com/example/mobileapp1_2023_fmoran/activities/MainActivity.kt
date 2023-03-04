package com.example.mobileapp1_2023_fmoran.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mobileapp1_2023_fmoran.R
import com.example.mobileapp1_2023_fmoran.databinding.ActivityMainBinding
import com.example.mobileapp1_2023_fmoran.models.MainActivityModel
import timber.log.Timber
import timber.log.Timber.i

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var newBooking = MainActivityModel()
    val bookings = ArrayList<MainActivityModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("Main Activity started...")

        binding.btnAdd.setOnClickListener() {
            newBooking.title = binding.bookingTitle.text.toString()
            if (newBooking.title.isNotEmpty()) {

                bookings.add(newBooking.copy())
                i("add Button Pressed: ${newBooking.title}")
                for (i in bookings.indices)
                { i("Booking[$i]:${this.bookings[i]}") }
            }
            else {
                Toast.makeText(this,"Please Enter a title", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}