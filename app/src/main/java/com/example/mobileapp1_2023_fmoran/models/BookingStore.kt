package com.example.mobileapp1_2023_fmoran.models

interface BookingStore {
    fun findAll(): List<BookingModel>
    fun create(placemark: BookingModel)
    fun update(placemark: BookingModel)
}