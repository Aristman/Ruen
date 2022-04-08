package ru.marslab.ruen.wordrepetition.repositories.room

import android.content.Context
import androidx.room.Room
import java.lang.RuntimeException

class DataBaseBuilder(private val context: Context) {
    private var db: RuenDatabase? = null
    fun getDataBase(): RuenDatabase {
        db ?: initDb()
        return db ?: throw RuntimeException("DB not initialized")
    }

    private fun initDb() {
        db = Room.databaseBuilder(
            context,
            RuenDatabase::class.java,
            "ruen.db"
        ).build()
    }
}