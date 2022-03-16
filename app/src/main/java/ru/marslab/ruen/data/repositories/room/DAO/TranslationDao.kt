package ru.marslab.ruen.data.repositories.room.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.marslab.ruen.data.repositories.room.entities.RoomTranslation

@Dao
interface TranslationDao {
    @Query("SELECT * FROM translations WHERE card_id=:cardId")
    fun get(cardId:Long):List<RoomTranslation>

    @Insert
    fun save(translation: RoomTranslation):Long

    @Insert
    fun save(translationList: List<RoomTranslation>):List<Long>

    @Delete
    fun delete(translation: RoomTranslation)
}