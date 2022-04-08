package ru.marslab.ruen.translation.models

import ru.marslab.ruen.translation.models.retrofit.SkyengAPI
import javax.inject.Singleton

@Singleton
class RemoteSource(private val api: SkyengAPI) : ISource {
    override suspend fun getTranslations(word: String) = api.getTranslation(word)
}