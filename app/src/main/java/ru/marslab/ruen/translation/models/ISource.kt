package ru.marslab.ruen.translation.models

import ru.marslab.ruen.translation.models.retrofit.beans.Word

interface ISource{
    suspend fun getTranslations(word: String) : List<Word>
}