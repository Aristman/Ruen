package ru.marslab.ruen.translation.models

import ru.marslab.ruen.translation.models.retrofit.beans.Word
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteSource: ISource
) {
    suspend fun getTranslation(word: String): List<Word> {
        return remoteSource.getTranslations(word)
    }

    fun saveWord() {

    }
}