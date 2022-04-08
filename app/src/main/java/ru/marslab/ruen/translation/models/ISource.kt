package ru.marslab.ruen.translation.models

import ru.marslab.ruen.translation.models.retrofit.beans.Words

interface ISource{
    suspend fun getTranslations(word: String) : Words
}