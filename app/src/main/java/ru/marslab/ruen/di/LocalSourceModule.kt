package ru.marslab.ruen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.marslab.ruen.data.room.RuenDatabase
import ru.marslab.ruen.translation.models.ILocalSource
import ru.marslab.ruen.translation.models.LocalSource
import ru.marslab.ruen.translation.models.room.WordMapper
import ru.marslab.ruen.wordrepetition.repositories.CardMapper

@Module
@InstallIn(ViewModelComponent::class)
object LocalSourceModule {
    @Provides
    fun provideLocalSources(
        db: RuenDatabase,
        wordMapper: WordMapper,
        cardMapper: CardMapper
    ): ILocalSource = LocalSource(db, wordMapper, cardMapper)
}