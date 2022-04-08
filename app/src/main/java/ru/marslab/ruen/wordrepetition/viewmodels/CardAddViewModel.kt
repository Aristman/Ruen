package ru.marslab.ruen.wordrepetition.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.marslab.ruen.wordrepetition.domain.Card
import ru.marslab.ruen.wordrepetition.domain.Translation
import ru.marslab.ruen.wordrepetition.exceptions.NoTranslationProvidedException
import ru.marslab.ruen.wordrepetition.repositories.ICardRepository
import javax.inject.Inject

@HiltViewModel
class CardAddViewModel @Inject constructor(
    private val repository: ICardRepository
) : ViewModel() {

    private val liveData = MutableLiveData<AppState>()
    private var card: Card? = null

    fun getLiveData(): LiveData<AppState> = liveData

    fun init(card: Card) {
        this.card = card
        liveData.postValue(AppState.Init(card))
    }

    fun save(translations: List<String>, customTranslate: String) {
        if (translations.isEmpty() && customTranslate.isEmpty()) {
            liveData.postValue(AppState.Error(NoTranslationProvidedException()))
            return
        }
        card?.let {
            it.translations?.apply {
                clear()
                addAll(translations.map { return@map Translation(value = it) })
            }
            val customTranslateTrimed = customTranslate.trim()
            if (customTranslateTrimed.isNotEmpty()) {
                it.translations?.add(Translation(value = customTranslate))
            }
            viewModelScope.launch(Dispatchers.IO) {
                repository.save(it)
                withContext(Dispatchers.Main) {
                    liveData.postValue(AppState.SavedSuccess)
                }
            }
        }
    }

    sealed class AppState {
        data class Init(val card: Card) : AppState()
        data class Error(val exception: Throwable) : AppState()
        object SavedSuccess : AppState()
    }
}