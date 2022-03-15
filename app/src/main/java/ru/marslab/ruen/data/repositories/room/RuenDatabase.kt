package ru.marslab.ruen.data.repositories.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.marslab.ruen.data.repositories.room.entities.RoomCard
import ru.marslab.ruen.data.repositories.room.entities.RoomImage
import ru.marslab.ruen.data.repositories.room.entities.RoomTranslation

@Database(
    entities = arrayOf(RoomCard::class, RoomTranslation::class, RoomImage::class),
    version = 1,
    exportSchema = false
)
abstract class RuenDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
    abstract fun translateDao(): TranslationDao
    abstract fun imageDao(): ImageDao
}