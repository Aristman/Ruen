package ru.marslab.ruen.data.retrofit.beans

data class Meaning(
    val id: Int,
    val imageUrl: String,
    val previewUrl: String,
    val soundUrl: String,
    val transcription: String,
    val translation: Translation
)
