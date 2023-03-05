package com.example.mobileapp1_2023_fmoran.models

class BookingMemStore : BookingStore {

    val placemarks = ArrayList<MainActivityModel>()

    override fun findAll(): List<MainActivityModel> {
        return placemarks
    }

    override fun create(placemark: MainActivityModel) {
        placemarks.add(placemark)
    }
}