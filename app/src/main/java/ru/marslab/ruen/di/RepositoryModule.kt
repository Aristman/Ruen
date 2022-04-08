package ru.marslab.ruen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.marslab.ruen.wordrepetition.repositories.CardRepository
import ru.marslab.ruen.wordrepetition.repositories.ICardRepository
import ru.marslab.ruen.wordrepetition.repositories.room.RuenDatabase

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun getCardRepository(database:RuenDatabase): ICardRepository=
        CardRepository(database)
}