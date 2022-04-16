package ru.marslab.ruen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.marslab.ruen.data.room.RuenDatabase
import ru.marslab.ruen.wordrepetition.repositories.CardMapper
import ru.marslab.ruen.wordrepetition.repositories.CardRepository
import ru.marslab.ruen.wordrepetition.repositories.ICardRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun getCardRepository(database: RuenDatabase, cardMapper: CardMapper): ICardRepository =
        CardRepository(database, cardMapper)
}
