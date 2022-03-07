package ru.marslab.ruen.data.repositories.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="cards")
data class RoomCard(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val value: String,
    val transcription:String?=null
)
