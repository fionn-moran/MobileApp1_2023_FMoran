package com.example.mobileapp1_2023_fmoran.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.mobileapp1_2023_fmoran.R
import com.example.mobileapp1_2023_fmoran.databinding.ActivityMainBinding
import com.example.mobileapp1_2023_fmoran.main.MainApp
import com.example.mobileapp1_2023_fmoran.models.MainActivityModel
import timber.log.Timber
import timber.log.Timber.i

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var newBooking = MainActivityModel()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
        i("Main Activity Started")
        binding.btnAdd.setOnClickListener() {
            newBooking.title = binding.bookingTitle.text.toString()
            newBooking.description = binding.description.text.toString()
            if (newBooking.title.isNotEmpty()) {
                app.bookings.create(newBooking.copy())
                i("add Button Pressed: ${newBooking.title}")
                setResult(RESULT_OK)
                finish()
            }
            else {
                Toast.makeText(this,"Please Enter a title", Toast.LENGTH_LONG)
                    .show()
            }
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