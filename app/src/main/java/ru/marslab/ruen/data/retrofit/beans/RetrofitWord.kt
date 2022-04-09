package ru.marslab.ruen.data.retrofit.beans

data class RetrofitWord(
    val id: Int,
    val meanings: List<Meaning>,
    val text: String
)