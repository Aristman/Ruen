package ru.marslab.ruen.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import ru.marslab.ruen.data.retrofit.beans.Words

interface SkyengAPI {
    @GET("words/search")
    suspend fun getTranslation(@Query("search") word: String): Words
}