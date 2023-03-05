package com.example.mobileapp1_2023_fmoran.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileapp1_2023_fmoran.R
import com.example.mobileapp1_2023_fmoran.adapters.BookingAdapter
import com.example.mobileapp1_2023_fmoran.adapters.BookingListener
import com.example.mobileapp1_2023_fmoran.databinding.ActivityBookingListBinding
import com.example.mobileapp1_2023_fmoran.main.MainApp
import com.example.mobileapp1_2023_fmoran.models.BookingModel

class BookingList : AppCompatActivity(), BookingListener {

    lateinit var app: MainApp
    private lateinit var binding: ActivityBookingListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        // binding.recyclerView.adapter = BookingAdapter(app.bookings)
        binding.recyclerView.adapter = BookingAdapter(app.bookings.findAll(),this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, MainActivity::class.java)
                getResult.launch(launcherIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.notifyItemRangeChanged(
                    0,
                    app.bookings.findAll().size)
            }
        }

    override fun OnBookingClick(booking: BookingModel) {
        val launcherIntent = Intent(this, MainActivity::class.java)
        launcherIntent.putExtra("booking_edit", booking)
        getClickResult.launch(launcherIntent)
    }

    private val getClickResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.notifyItemRangeChanged(
                    0,
                    app.bookings.findAll().size)
            }
        }
}