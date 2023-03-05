package com.example.mobileapp1_2023_fmoran.activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.mobileapp1_2023_fmoran.R
import com.example.mobileapp1_2023_fmoran.databinding.ActivityMainBinding
import com.example.mobileapp1_2023_fmoran.main.MainApp
import com.example.mobileapp1_2023_fmoran.models.MealModel
import timber.log.Timber.i
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var newMeal = MealModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var edit = false

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)
        app = application as MainApp
        i("Main Activity Started")


        //Dialog for below is showing upon button click, but app crashes when a date is selected.
        /*
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        binding.dateBtn.setOnClickListener {
               val datePickerDialog = DatePickerDialog (
                this, DatePickerDialog.OnDateSetListener { datePicker, myear, mmonth, mday ->
                    binding.dateText.setText(mday + mmonth + myear)
                }, year, month, day)
            datePickerDialog.show()
            }

         */

        if (intent.hasExtra("booking_edit")) {
            edit = true
            newMeal = intent.extras?.getParcelable("booking_edit")!!
            binding.mealTitle.setText(newMeal.title)
            binding.description.setText(newMeal.description)
            binding.calories.setText(newMeal.calories)
            binding.protein.setText(newMeal.protein)
            binding.btnAdd.setText(R.string.save_meal)
        }

        binding.btnAdd.setOnClickListener() {
            newMeal.title = binding.mealTitle.text.toString()
            newMeal.description = binding.description.text.toString()
            newMeal.calories = binding.calories.text.toString()
            newMeal.protein = binding.protein.text.toString()
            if (newMeal.title.isEmpty()) {
                Toast.makeText(this, "Please Enter a Meal Name", Toast.LENGTH_LONG)
                    .show()
            }
            if (newMeal.description.isEmpty()) {
                Toast.makeText(this, "Please Enter a Meal Description", Toast.LENGTH_LONG)
                    .show()
            }
            if (newMeal.calories.isEmpty()) {
                Toast.makeText(this, "Please Enter the number of calories", Toast.LENGTH_LONG)
                    .show()
            }
            if (newMeal.protein.isEmpty()) {
                Toast.makeText(this, "Please Enter the protein content", Toast.LENGTH_LONG)
                    .show()
            }
            else {
                if (edit) {
                    app.meals.update(newMeal.copy())
                } else {
                    app.meals.create(newMeal.copy())
                }
            }
            i("add Button Pressed: ${newMeal.title}")
            setResult(RESULT_OK)
            finish()
        }

    }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.menu_cancel, menu)
            return super.onCreateOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.item_cancel -> {
                    finish()
                }
            }
            return super.onOptionsItemSelected(item)
        }
}