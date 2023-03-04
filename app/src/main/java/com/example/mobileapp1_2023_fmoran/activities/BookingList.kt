package com.example.mobileapp1_2023_fmoran.activities

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileapp1_2023_fmoran.R
import com.example.mobileapp1_2023_fmoran.main.MainApp

class BookingList : AppCompatActivity() {

    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_list)
        app = application as MainApp
    }
}