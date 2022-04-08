package ru.marslab.ruen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.marslab.ruen.translation.models.ISource
import ru.marslab.ruen.translation.models.RemoteSource
import ru.marslab.ruen.translation.models.retrofit.SkyengAPI

@Module
@InstallIn(ViewModelComponent::class)
object RemoteSourceModule {
    @Provides
    fun getRemoteSource(api: SkyengAPI): ISource = RemoteSource(api)
}