package com.example.mobileapp1_2023_fmoran.models

interface BookingStore {
    fun findAll(): List<MainActivityModel>
    fun create(placemark: MainActivityModel)
}