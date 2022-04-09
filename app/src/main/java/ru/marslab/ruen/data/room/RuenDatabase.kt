package ru.marslab.ruen.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.marslab.ruen.data.room.dao.CardDao
import ru.marslab.ruen.data.room.dao.TranslationDao
import ru.marslab.ruen.data.room.converters.DateConverter
import ru.marslab.ruen.data.room.dao.WordDao
import ru.marslab.ruen.data.room.entities.RoomCard
import ru.marslab.ruen.data.room.entities.RoomTranslation
import ru.marslab.ruen.data.room.entities.RoomWord

@Database(
    entities = arrayOf(RoomCard::class, RoomTranslation::class, RoomWord::class),
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class RuenDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
    abstract fun translateDao(): TranslationDao
    abstract fun wordDao(): WordDao
}