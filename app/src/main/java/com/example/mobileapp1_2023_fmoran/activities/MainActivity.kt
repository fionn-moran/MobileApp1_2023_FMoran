package com.example.mobileapp1_2023_fmoran.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileapp1_2023_fmoran.R
import com.example.mobileapp1_2023_fmoran.databinding.ActivityMainBinding
import timber.log.Timber
import timber.log.Timber.i

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("Main Activity started...")

        binding.btnAdd.setOnClickListener() {
            i("add Button Pressed")
        }
    }
}