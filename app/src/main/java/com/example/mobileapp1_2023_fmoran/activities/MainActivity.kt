package com.example.mobileapp1_2023_fmoran.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileapp1_2023_fmoran.R
import timber.log.Timber
import timber.log.Timber.i

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        i("Main Activity started...")


    }
}