package ru.marslab.ruen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.marslab.ruen.data.retrofit.SkyengAPI
import ru.marslab.ruen.translation.models.IRemoteSource
import ru.marslab.ruen.translation.models.RemoteSource

@Module
@InstallIn(ViewModelComponent::class)
object RemoteSourceModule {
    @Provides
    fun getRemoteSource(api: SkyengAPI): IRemoteSource = RemoteSource(api)
}
