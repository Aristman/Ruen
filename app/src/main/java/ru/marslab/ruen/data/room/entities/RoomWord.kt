package ru.marslab.ruen.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class RoomWord(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val value: String,
    val translation: String?
)
