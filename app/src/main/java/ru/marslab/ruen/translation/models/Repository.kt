package ru.marslab.ruen.translation.models

import ru.marslab.ruen.translation.models.retrofit.beans.Words
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteSource: ISource
) {
    suspend fun getTranslation(word: String): Words {
        return remoteSource.getTranslations(word)
    }

    fun saveWord() {

    }
}