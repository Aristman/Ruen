package ru.marslab.ruen.translation.models

import ru.marslab.ruen.translation.models.retrofit.SkyengAPI
import ru.marslab.ruen.translation.models.retrofit.beans.Meaning
import ru.marslab.ruen.translation.models.retrofit.beans.Words
import javax.inject.Singleton

@Singleton
class RemoteSource(private val api: SkyengAPI) : ISource {
    override suspend fun getTranslations(word: String) = api.getTranslation(word).map { word ->
        val meanings = word.meanings.map { meaning ->
            meaning.copy(imageUrl = "https:" + meaning.imageUrl)
        }
        return@map word.copy(meanings = meanings)
    }
}