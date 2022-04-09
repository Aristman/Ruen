package ru.marslab.ruen.translation.models

import kotlinx.coroutines.flow.Flow
import ru.marslab.ruen.translation.beans.Word
import ru.marslab.ruen.wordrepetition.domain.Card

interface ILocalSource {
    fun getWords(): Flow<List<Word>>
    suspend fun insertWord(word: Word)
    suspend fun getLastCard(): Card?
}