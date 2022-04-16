package ru.marslab.ruen.wordrepetition.utilities

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

private const val LANGUAGE = "en"
private const val TAG = "TTS"
private const val NOT_SUPPORTED_LANGUAGE = "Извините, этот язык не поддерживается"
private const val ERROR = "Ошибка!"

class AppTextToSpeech(private val context: Context, private val success: (() -> Unit)? = null) :
    TextToSpeech.OnInitListener, ITextToSpeech {
    private val textToSpeech = TextToSpeech(context, this)

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val locale = Locale(LANGUAGE)
            val result: Int = textToSpeech.setLanguage(locale)
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                result == TextToSpeech.LANG_NOT_SUPPORTED
            ) {
                Log.e(TAG, NOT_SUPPORTED_LANGUAGE)
            } else {
                success?.invoke()
            }
        } else {
            Log.e(TAG, ERROR)
        }
    }

    override fun speak(text: String) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null)
    }

    override fun stop() {
        textToSpeech.stop()
    }

    override fun shutdown() {
        textToSpeech.shutdown()
    }
}
