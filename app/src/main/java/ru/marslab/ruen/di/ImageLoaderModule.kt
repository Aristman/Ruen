package ru.marslab.ruen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.marslab.ruen.wordrepetition.utilities.GlideImageLoader
import ru.marslab.ruen.wordrepetition.utilities.IImageLoader

@Module
@InstallIn(FragmentComponent::class)
object ImageLoaderModule {
    @Provides
    fun bindImageLoader(): IImageLoader =
        GlideImageLoader()
}
