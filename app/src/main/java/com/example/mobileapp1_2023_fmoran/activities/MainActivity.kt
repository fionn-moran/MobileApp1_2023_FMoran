package com.example.mobileapp1_2023_fmoran.activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CalendarView
import android.widget.Toast
import com.example.mobileapp1_2023_fmoran.R
import com.example.mobileapp1_2023_fmoran.databinding.ActivityMainBinding
import com.example.mobileapp1_2023_fmoran.main.MainApp
import com.example.mobileapp1_2023_fmoran.models.BookingModel
import timber.log.Timber.i
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var newBooking = BookingModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var edit = false

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)
        app = application as MainApp
        i("Main Activity Started")

        if (intent.hasExtra("booking_edit")) {
            edit = true
            newBooking = intent.extras?.getParcelable("booking_edit")!!
            binding.mealTitle.setText(newBooking.title)
            binding.description.setText(newBooking.description)
            binding.calories.setText(newBooking.calories)
            binding.protein.setText(newBooking.protein)
            binding.btnAdd.setText(R.string.save_booking)
        }

        binding.btnAdd.setOnClickListener() {
            newBooking.title = binding.mealTitle.text.toString()
            newBooking.description = binding.description.text.toString()
            newBooking.calories = binding.calories.text.toString()
            newBooking.protein = binding.protein.text.toString()
            if (newBooking.title.isEmpty()) {
                Toast.makeText(this, "Please Enter a Meal Name", Toast.LENGTH_LONG)
                    .show()
            } else {
                if (edit) {
                    app.bookings.update(newBooking.copy())
                } else {
                    app.bookings.create(newBooking.copy())
                }
            }
            i("add Button Pressed: ${newBooking.title}")
            setResult(RESULT_OK)
            finish()
        }

    }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.menu_cancel, menu)
            return super.onCreateOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.item_cancel -> {
                    finish()
                }
            }
            return super.onOptionsItemSelected(item)
        }
}