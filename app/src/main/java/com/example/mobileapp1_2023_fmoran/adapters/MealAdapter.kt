package com.example.mobileapp1_2023_fmoran.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp1_2023_fmoran.databinding.MealCardViewBinding
import com.example.mobileapp1_2023_fmoran.models.MealModel

interface MealListener {
    fun onBookingClick(meal: MealModel)
}

class MealAdapter constructor(private var meals: List<MealModel>, private val listener: MealListener) :
    RecyclerView.Adapter<MealAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = MealCardViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val meal = meals[holder.adapterPosition]
        holder.bind(meal, listener)
    }

    override fun getItemCount(): Int = meals.size

    class MainHolder(private val binding : MealCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: MealModel, listener: MealListener) {
            binding.title.text = meal.title
            binding.description.text = meal.description
            binding.calories.text = meal.calories
            binding.protein.text = meal.protein
            binding.root.setOnClickListener { listener.onBookingClick(meal) }
        }
    }
}