package com.example.mobileapp1_2023_fmoran.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp1_2023_fmoran.databinding.BookingCardViewBinding
import com.example.mobileapp1_2023_fmoran.models.MainActivityModel

interface BookingListener {
    fun OnBookingClick(booking: MainActivityModel)
}

class BookingAdapter constructor(private var bookings: List<MainActivityModel>, private val listener: BookingListener) :
    RecyclerView.Adapter<BookingAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = BookingCardViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val booking = bookings[holder.adapterPosition]
        holder.bind(booking, listener)
    }

    override fun getItemCount(): Int = bookings.size

    class MainHolder(private val binding : BookingCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(booking: MainActivityModel, listener: BookingListener) {
            binding.title.text = booking.title
            binding.description.text = booking.description
            binding.root.setOnClickListener { listener.OnBookingClick(booking) }
        }
    }
}