package ru.marslab.ruen.translation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.marslab.ruen.translation.models.Repository
import ru.marslab.ruen.translation.models.retrofit.beans.Word
import ru.marslab.ruen.wordrepetition.domain.Card
import ru.marslab.ruen.wordrepetition.domain.Translation
import ru.marslab.ruen.wordrepetition.utilities.ITextToSpeech
import ru.marslab.ruen.wordrepetition.utilities.TTS
import javax.inject.Inject

@HiltViewModel
class TranslationViewModel @Inject constructor(
    private val repository: Repository,
    private val tts: ITextToSpeech
) : ViewModel() {
    private var wordString: String? = null
    private var storedWord: Word? = null
    private val liveData = MutableLiveData<AppState>()
    fun translate(query: String): LiveData<AppState> {
        storedWord = null
        liveData.postValue(AppState.Loading)
        wordString = query
        viewModelScope.launch(Dispatchers.IO) {
            val words = repository.getTranslation(query)
            withContext(Dispatchers.Main) {
                if (words.size == 0) {
                    liveData.postValue(AppState.NotFound)
                    return@withContext
                }
                val word = words[0]
                storedWord = word
                liveData.postValue(AppState.Success(word))
            }
        }
        return liveData
    }

    fun voiceClicked() {
        wordString?.let {
            tts.speak(it)
        }
    }

    fun createCardClicked() {
        if (storedWord == null) {
            liveData.postValue(AppState.NoCard)
        } else {
            val word = storedWord!!
            val meanings = word.meanings
            val translations = meanings.map { Translation(value = it.translation.text) }
            var imageUrl: String? = null
            var transcription: String? = null
            if (meanings.size > 0) {
                val meaning = meanings[0]
                imageUrl = meaning.imageUrl
                transcription = meaning.transcription
            }
            wordString?.let { word ->
                val card = Card(
                    value = word,
                    transcription = transcription,
                    imageUrl = imageUrl,
                    translations = translations.toMutableList()
                )
                liveData.postValue(AppState.CreatedCard(card))
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        tts.stop()
        tts.shutdown()
    }
}

sealed class AppState {
    data class Success(val word: Word) : AppState()
    object NotFound : AppState()
    object Loading : AppState()
    data class CreatedCard(val card: Card) : AppState()
    object NoCard : AppState()
}