package ru.marslab.ruen.wordrepetition.repositories.room.converters

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun toLong(date: Date?) = date?.time

    @TypeConverter
    fun toDate(time: Long?): Date? {
        return time?.let {
            Date(it)
        }
    }

}