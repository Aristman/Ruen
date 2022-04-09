package ru.marslab.ruen.translation.models

import kotlinx.coroutines.flow.Flow
import ru.marslab.ruen.translation.beans.Word

interface ILocalSource {
    fun getWords(): Flow<List<Word>>
    suspend fun insertWord(word: Word)
}