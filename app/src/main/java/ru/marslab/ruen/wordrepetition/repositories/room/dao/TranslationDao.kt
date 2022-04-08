package ru.marslab.ruen.wordrepetition.repositories.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.marslab.ruen.wordrepetition.repositories.room.entities.RoomTranslation

@Dao
interface TranslationDao {
    @Query("SELECT * FROM translations WHERE card_id=:cardId")
    suspend fun get(cardId:Long):List<RoomTranslation>

    @Insert(onConflict = REPLACE)
    suspend fun save(translation: RoomTranslation):Long

    @Insert(onConflict = REPLACE)
    suspend fun save(translationList: List<RoomTranslation>):List<Long>

    @Delete
    suspend fun delete(translation: RoomTranslation)
}