package ru.marslab.ruen.data.room.converters

import androidx.room.TypeConverter
import java.util.Date

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
