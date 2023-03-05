package com.example.mobileapp1_2023_fmoran.main

import android.app.Application
import com.example.mobileapp1_2023_fmoran.models.BookingMemStore
import com.example.mobileapp1_2023_fmoran.models.MainActivityModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    //val bookings = ArrayList<MainActivityModel>()
    val bookings = BookingMemStore()
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Main Activity Started")
    }
}