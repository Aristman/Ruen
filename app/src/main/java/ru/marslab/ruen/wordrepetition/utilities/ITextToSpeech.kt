package ru.marslab.ruen.wordrepetition.utilities

interface ITextToSpeech {
    fun speak(text: String)
    fun stop()
    fun shutdown()
}
