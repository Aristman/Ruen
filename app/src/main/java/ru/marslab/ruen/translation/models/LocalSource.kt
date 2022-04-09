package ru.marslab.ruen.translation.models

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.marslab.ruen.data.room.RuenDatabase
import ru.marslab.ruen.translation.beans.Word
import ru.marslab.ruen.translation.models.room.WordMapper
import ru.marslab.ruen.wordrepetition.repositories.CardMapper

class LocalSource(
    private val db: RuenDatabase,
    private val wordMapper: WordMapper,
    private val cardMapper: CardMapper
) : ILocalSource {
    override fun getWords(): Flow<List<Word>> = db.wordDao().getWords().map { list ->
        list.map { roomWord ->
            wordMapper.toWord(roomWord)
        }
    }

    override suspend fun insertWord(word: Word) {
        db.wordDao().insertWord(wordMapper.toRoomWord(word))
    }

    override suspend fun getLastCard() = db.cardDao().getLastCard()?.let {
        cardMapper.toCard(it)
    }

}