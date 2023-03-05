package com.example.mobileapp1_2023_fmoran.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp1_2023_fmoran.databinding.BookingCardViewBinding
import com.example.mobileapp1_2023_fmoran.models.MainActivityModel

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