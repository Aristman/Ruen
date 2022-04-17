package ru.marslab.ruen.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.marslab.ruen.data.room.RuenDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun bindDataBase(@ApplicationContext context: Context): RuenDatabase =
        Room.databaseBuilder(
            context,
            RuenDatabase::class.java,
            DB_NAME
        ).build()

    const val DB_NAME = "ruen.db"
}
