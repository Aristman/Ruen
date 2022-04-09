package ru.marslab.ruen.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.marslab.ruen.data.retrofit.SkyengAPI

@Module
@InstallIn(ViewModelComponent::class)
object RetrofitModule {
    @Provides
    fun getRetrofit(gsonConverterFactory: GsonConverterFactory): SkyengAPI = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(gsonConverterFactory)
        .build()
        .create(SkyengAPI::class.java)

    @Provides
    fun getGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create(GsonBuilder().setLenient().create())

    private const val url = "https://dictionary.skyeng.ru/api/public/v1/"
}