package ru.marslab.ruen.wordrepetition.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.marslab.ruen.wordrepetition.utilities.GlideImageLoader
import ru.marslab.ruen.wordrepetition.utilities.IImageLoader

@Module
@InstallIn(FragmentComponent::class)
object ImageLoaderModule {
    @Provides
    fun bindImageLoader(): IImageLoader =
        GlideImageLoader()
}