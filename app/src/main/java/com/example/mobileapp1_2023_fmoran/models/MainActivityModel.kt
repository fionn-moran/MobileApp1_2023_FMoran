package com.example.mobileapp1_2023_fmoran.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MainActivityModel(var title: String = "", var description: String = "") : Parcelable
