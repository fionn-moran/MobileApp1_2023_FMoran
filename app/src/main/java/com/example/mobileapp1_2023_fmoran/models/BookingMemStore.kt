package com.example.mobileapp1_2023_fmoran.models

import timber.log.Timber.i

class BookingMemStore : BookingStore {

    val placemarks = ArrayList<MainActivityModel>()

    override fun findAll(): List<MainActivityModel> {
        return placemarks
    }

    override fun create(placemark: MainActivityModel) {
        placemarks.add(placemark)
        logAll()
    }

    fun logAll() {
        placemarks.forEach{ i("${it}") }
    }
}