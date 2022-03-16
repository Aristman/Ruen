package ru.marslab.ruen.data.repositories.room.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.marslab.ruen.data.repositories.room.entities.RoomCard

@Dao
interface CardDao {
    @Query("SELECT * FROM cards")
    fun get():List<RoomCard>

    @Insert
    fun save(card: RoomCard):Long

    @Delete
    fun delete(card: RoomCard)
}