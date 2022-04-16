package ru.marslab.ruen.wordrepetition.utilities

import java.time.temporal.ChronoUnit
import java.util.Date

class DateProvider {
    fun getCurrentDateWithoutTime() = getDateWithoutTime(Date())

    fun getDateWithoutTime(date: Date) = Date.from(
        date.toInstant().truncatedTo(ChronoUnit.DAYS)
    )
}
