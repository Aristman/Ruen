package ru.marslab.ruen.translation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.marslab.ruen.data.retrofit.beans.RetrofitWord
import ru.marslab.ruen.translation.beans.Word
import ru.marslab.ruen.translation.models.Repository
import ru.marslab.ruen.wordrepetition.domain.Card
import ru.marslab.ruen.wordrepetition.domain.Translation
import ru.marslab.ruen.wordrepetition.utilities.ITextToSpeech
import javax.inject.Inject

@HiltViewModel
class TranslationViewModel @Inject constructor(
    private val repository: Repository,
    private val tts: ITextToSpeech,
) : ViewModel() {
    private var wordString: String? = null
    private var storedWord: RetrofitWord? = null
    private val liveData = MutableLiveData<AppState>()
    fun translate(query: String): LiveData<AppState> {
        storedWord = null
        liveData.postValue(AppState.Loading)
        wordString = query
        viewModelScope.launch(Dispatchers.IO) {
            val words = repository.getTranslation(query)
            withContext(Dispatchers.Main) {
                if (words.isEmpty()) {
                    liveData.postValue(AppState.NotFound)
                    return@withContext
                }
                val word = words.first()
                storedWord = word
                liveData.postValue(AppState.Success(word))
                withContext(Dispatchers.IO) {
                    val translation =
                        if (word.meanings.isNotEmpty()) word.meanings.first().translation.text else null
                    wordString?.let {
                        repository.saveWord(Word(value = wordString!!, translation = translation))
                    }
                }
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
            if (meanings.isNotEmpty()) {
                val meaning = meanings[0]
                imageUrl = meaning.imageUrl
                transcription = meaning.transcription
            }
            val card = Card(
                value = wordString.orEmpty(),
                transcription = transcription,
                imageUrl = imageUrl,
                translations = translations.toMutableList()
            )
            liveData.postValue(AppState.CreatedCard(card))
        }
    }

    override fun onCleared() {
        super.onCleared()
        tts.stop()
        tts.shutdown()
    }
}

sealed class AppState {
    data class Success(val word: RetrofitWord) : AppState()
    object NotFound : AppState()
    object Loading : AppState()
    data class CreatedCard(val card: Card) : AppState()
    object NoCard : AppState()
}
