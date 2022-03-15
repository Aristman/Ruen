package ru.marslab.ruen.data.repositories.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(CardDao::class, TranslationDao::class, ImageDao::class),
    version = 1,
    exportSchema = false
)
abstract class RuenDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
    abstract fun translateDao(): TranslationDao
    abstract fun imageDao(): ImageDao
}