package ru.marslab.ruen.data.repositories.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class RoomImage(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val url: String,
    @ColumnInfo(name = "card_id")
    var cardId: Long? = null
)
