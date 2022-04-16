package ru.marslab.ruen.translation.models

import ru.marslab.ruen.data.retrofit.beans.RetrofitWord

interface IRemoteSource {
    suspend fun getTranslations(word: String): List<RetrofitWord>
}
