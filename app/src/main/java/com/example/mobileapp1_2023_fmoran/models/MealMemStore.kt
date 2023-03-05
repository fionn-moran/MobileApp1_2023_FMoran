package com.example.mobileapp1_2023_fmoran.models

import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class MealMemStore : MealStore {

    val meals = ArrayList<MealModel>()

    override fun findAll(): List<MealModel> {
        return meals
    }

    override fun create(meal: MealModel) {
        meal.id = getId()
        meals.add(meal)
        logAll()
    }

    override fun update(meal: MealModel) {
        var foundMeal: MealModel? = meals.find { p -> p.id == meal.id }
        if (foundMeal != null) {
            foundMeal.title = meal.title
            foundMeal.description = meal.description
            foundMeal.calories = meal.calories
            foundMeal.protein = meal.protein
            logAll()
        }
    }

    //Delete function
    override fun delete(meal: MealModel) {
        var foundMeal: MealModel? = meals.find { p -> p.id == meal.id }
        if (foundMeal != null) {
            meals.remove(foundMeal)
            logAll()
        }
    }

    private fun logAll() {
        meals.forEach{ i("${it}") }
    }
}