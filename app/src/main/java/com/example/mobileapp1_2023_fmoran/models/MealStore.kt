package com.example.mobileapp1_2023_fmoran.models

interface MealStore {
    fun findAll(): List<MealModel>
    fun create(meal: MealModel)
    fun update(meal: MealModel)
    fun delete(meal: MealModel)
}