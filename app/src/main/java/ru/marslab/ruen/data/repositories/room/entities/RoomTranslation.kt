package ru.marslab.ruen.data.repositories.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "translations")
data class RoomTranslation(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val value: String,
    @ColumnInfo(name = "card_id")
    var cardId: Long? = null
)
