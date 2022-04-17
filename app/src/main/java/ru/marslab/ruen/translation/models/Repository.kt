package ru.marslab.ruen.translation.models

import ru.marslab.ruen.data.retrofit.beans.RetrofitWord
import ru.marslab.ruen.translation.beans.Word
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteSource: IRemoteSource,
    private val localSource: ILocalSource
) {
    suspend fun getTranslation(word: String): List<RetrofitWord> {
        return remoteSource.getTranslations(word)
    }

    fun getWords() = localSource.getWords()

    suspend fun saveWord(word: Word) {
        localSource.insertWord(word)
    }

    suspend fun getLastCard() = localSource.getLastCard()
}
