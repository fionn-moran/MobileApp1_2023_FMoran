package com.example.mobileapp1_2023_fmoran.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MealModel(var id: Long = 0,
                     var title: String = "",
                     var description: String = "",
                     var calories: String = "",
                     var protein: String = "") : Parcelable
