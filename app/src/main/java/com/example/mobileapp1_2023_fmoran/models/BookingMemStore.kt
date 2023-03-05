package com.example.mobileapp1_2023_fmoran.models

import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class BookingMemStore : BookingStore {

    val bookings = ArrayList<BookingModel>()

    override fun findAll(): List<BookingModel> {
        return bookings
    }

    override fun create(booking: BookingModel) {
        booking.id = getId()
        bookings.add(booking)
        logAll()
    }

    override fun update(booking: BookingModel) {
        var foundBooking: BookingModel? = bookings.find { p -> p.id == booking.id }
        if (foundBooking != null) {
            foundBooking.title = booking.title
            foundBooking.description = booking.description
            foundBooking.calories = booking.calories
            foundBooking.protein = booking.protein
            logAll()
        }
    }

    private fun logAll() {
        bookings.forEach{ i("${it}") }
    }
}