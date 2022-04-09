package ru.marslab.ruen.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.marslab.ruen.data.room.entities.RoomCard
import java.util.*

@Dao
interface CardDao {
    @Query("SELECT * FROM cards ORDER BY next_date_repeating")
    fun get(): Flow<List<RoomCard>>

    @Query(
        "SELECT * FROM cards WHERE next_date_repeating<=:date OR next_date_repeating=null " +
                "ORDER BY next_date_repeating LIMIT 1"
    )
    suspend fun getCardForRepeating(date: Date): RoomCard?

    @Query("SELECT * FROM cards ORDER BY next_date_repeating LIMIT 1")
    suspend fun getLastCard(): RoomCard?

    @Insert(onConflict = REPLACE)
    suspend fun save(card: RoomCard): Long

    @Delete
    suspend fun delete(card: RoomCard)
}