package ru.marslab.ruen.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.marslab.ruen.data.room.entities.RoomWord

@Dao
interface WordDao {
    @Query("SELECT * FROM words")
    fun getWords(): Flow<List<RoomWord>>

    @Insert
    suspend fun insertWord(word: RoomWord): Long

    @Query("DELETE FROM words ORDER BY id ASC LIMIT :count")
    suspend fun deleteFirstWords(count: Int)
}