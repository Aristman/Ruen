package ru.marslab.ruen.translation.models.retrofit.beans

data class Word(
    val id: Int,
    val meanings: List<Meaning>,
    val text: String
)