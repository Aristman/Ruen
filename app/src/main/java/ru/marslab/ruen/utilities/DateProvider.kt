package ru.marslab.ruen.utilities

import java.time.temporal.ChronoUnit
import java.util.*

class DateProvider {
    fun getCurrentDateWithoutTime() = getDateWithoutTime(Date())

    fun getDateWithoutTime(date: Date) = Date.from(
        date.toInstant().truncatedTo(ChronoUnit.DAYS)
    )
}