package com.example.mobileapp1_2023_fmoran.activities

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp1_2023_fmoran.R
import com.example.mobileapp1_2023_fmoran.databinding.ActivityBookingListBinding
import com.example.mobileapp1_2023_fmoran.databinding.ActivityMainBinding
import com.example.mobileapp1_2023_fmoran.databinding.BookingCardViewBinding
import com.example.mobileapp1_2023_fmoran.main.MainApp
import com.example.mobileapp1_2023_fmoran.models.MainActivityModel

class BookingList : AppCompatActivity() {

    lateinit var app : MainApp
    private lateinit var binding : ActivityBookingListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = BookingAdapter(app.bookings)
    }
}

class BookingAdapter constructor(private var placemarks: List<MainActivityModel>) :
    RecyclerView.Adapter<BookingAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = BookingCardViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val placemark = placemarks[holder.adapterPosition]
        holder.bind(placemark)
    }

    override fun getItemCount(): Int = placemarks.size

    class MainHolder(private val binding : BookingCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(placemark: MainActivityModel) {
            binding.title.text = placemark.title
            binding.description.text = placemark.description
        }
    }
}