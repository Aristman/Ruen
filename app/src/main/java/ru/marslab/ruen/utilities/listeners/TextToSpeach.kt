package ru.marslab.ruen.utilities

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.*

class TTSFactory(private val context: Context, private val success: (() -> Unit)? = null) :
    TextToSpeech.OnInitListener {
    private val tts = TextToSpeech(context, this)

    override fun onInit(status: Int) {
        if (status === TextToSpeech.SUCCESS) {
            val locale = Locale(LANGUAGE)
            val result: Int = tts.setLanguage(locale)
            if (result == TextToSpeech.LANG_MISSING_DATA
                || result == TextToSpeech.LANG_NOT_SUPPORTED
            ) {
                Log.e(TAG, NOT_SUPPORTED_LANGUAGE)
            } else {
                success?.invoke()
            }
        } else {
            Log.e(TAG, ERROR)
        }
    }

    fun getInstance() = tts

    companion object {
        private const val LANGUAGE = "en"
        private const val TAG = "TTS"
        private const val NOT_SUPPORTED_LANGUAGE = "Извините, этот язык не поддерживается"
        private const val ERROR = "Ошибка!"
    }
}