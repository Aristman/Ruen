package ru.marslab.ruen.data.repositories.room.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.marslab.ruen.data.repositories.room.entities.RoomCard
import java.util.*

@Dao
interface CardDao {
    @Query("SELECT * FROM cards")
    suspend fun get(): List<RoomCard>

    @Query("SELECT * FROM cards WHERE next_date_repeating<=:date OR next_date_repeating=null")
    suspend fun getCardsForRepeating(date: Date): List<RoomCard>

    @Insert(onConflict = REPLACE)
    suspend fun save(card: RoomCard): Long

    @Delete
    suspend fun delete(card: RoomCard)
}