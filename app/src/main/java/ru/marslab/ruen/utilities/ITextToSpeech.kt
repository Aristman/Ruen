package ru.marslab.ruen.utilities

interface ITextToSpeech {
    fun speak(text: String)
    fun stop()
    fun shutdown()
}