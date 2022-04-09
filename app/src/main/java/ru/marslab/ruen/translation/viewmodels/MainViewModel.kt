package ru.marslab.ruen.translation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.marslab.ruen.translation.beans.Word
import ru.marslab.ruen.translation.models.Repository
import ru.marslab.ruen.wordrepetition.domain.Card
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val liveData = MutableLiveData<MainAppState>()

    fun getLiveDate(): LiveData<MainAppState> = liveData

    fun translateClicked(query: String) {
        val word = query.trim()
        val appState = if (word.isEmpty()) MainAppState.NoWord else MainAppState.Translation(word)
        liveData.postValue(appState)
    }

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            setCardState()
            setHistoryState()
        }
    }

    private suspend fun setHistoryState() {
        repository.getWords().collect { list ->
            withContext(Dispatchers.Main) {
                liveData.postValue(MainAppState.History(list))
            }
        }
    }

    private suspend fun setCardState() {
        val card = repository.getLastCard()
        withContext(Dispatchers.Main) {
            val state =
                if (card == null) MainAppState.CardNull else MainAppState.LastCard(card!!)
            liveData.postValue(state)
        }
    }
}

sealed class MainAppState {
    data class Translation(val word: String) : MainAppState()
    object NoWord : MainAppState()
    data class History(val words: List<Word>) : MainAppState()
    object CardNull : MainAppState()
    data class LastCard(val card: Card) : MainAppState()
}