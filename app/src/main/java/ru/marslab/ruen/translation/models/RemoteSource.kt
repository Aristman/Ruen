package ru.marslab.ruen.translation.models

import ru.marslab.ruen.data.retrofit.SkyengAPI
import javax.inject.Singleton

@Singleton
class RemoteSource(private val api: SkyengAPI) : IRemoteSource {
    override suspend fun getTranslations(word: String) = api.getTranslation(word).map { retrofitWord ->
        val meanings = retrofitWord.meanings.map { meaning ->
            meaning.copy(imageUrl = "https:" + meaning.imageUrl)
        }
        return@map retrofitWord.copy(meanings = meanings)
    }
}