package ru.marslab.ruen.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.marslab.ruen.data.room.entities.RoomWord

@Dao
interface WordDao {
    @Query("SELECT * FROM words ORDER BY id DESC")
    fun getWords(): Flow<List<RoomWord>>

    @Insert
    suspend fun insertWord(word: RoomWord): Long
}
