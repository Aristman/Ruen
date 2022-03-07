package ru.marslab.ruen.data.repositories.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.marslab.ruen.data.repositories.room.entities.RoomImage

@Dao
interface ImageDao {
    @Query("SELECT * FROM images WHERE card_id = :cardId")
    fun get(cardId:Long):List<RoomImage>

    @Insert
    fun save(image: RoomImage):Long

    @Delete
    fun delete(image: RoomImage)
}