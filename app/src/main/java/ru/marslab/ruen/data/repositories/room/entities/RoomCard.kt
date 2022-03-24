package ru.marslab.ruen.data.repositories.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.marslab.ruen.data.repositories.room.converters.DateConverter
import java.util.*

@Entity(tableName = "cards")
data class RoomCard(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val value: String,
    val transcription: String? = null,
    @ColumnInfo(name = "image_url")
    val imageUrl: String? = null,
    @ColumnInfo(name = "next_date_repeating")
    val nextDateRepeating: Date,
    @ColumnInfo(name = "count_repeat")
    val countRepeat: Int
)
