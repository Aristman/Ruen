package ru.marslab.ruen.translation.models.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import ru.marslab.ruen.translation.models.retrofit.beans.Words

interface SkyengAPI {
    @GET("words/search")
    suspend fun getTranslation(@Query("search") word: String): Words
}