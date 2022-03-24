package ru.marslab.ruen.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.marslab.ruen.Card
import ru.marslab.ruen.data.repositories.ICardRepository
import ru.marslab.ruen.utilities.ITextToSpeech
import ru.marslab.ruen.utilities.TTS
import java.time.temporal.ChronoUnit
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CardRepeatingViewModel @Inject constructor(
    private val repository: ICardRepository,
    private val tts: ITextToSpeech
) : BaseViewModel() {

    private val _liveData = MutableLiveData<AppState>()
    private var card: Card? = null
    val liveData: LiveData<AppState> = _liveData

    override fun handleError(e: Throwable) {
        Log.e(TAG, e.stackTraceToString())
    }

    override fun onCleared() {
        super.onCleared()
        tts.stop()
        tts.shutdown()
    }

    fun init() {
        getCard()
    }

    fun getCard() {
        _liveData.postValue(AppState.Loading)
        coroutineScope.launch {
            card = repository.getCardForRepeating()
            withContext(Dispatchers.Main) {
                if (card == null) {
                    _liveData.postValue(AppState.NoCard)
                } else {
                    _liveData.postValue(AppState.Success(card!!))
                }
            }
        }
    }

    fun speechClicked() {
        card?.let { card ->
            tts.speak(card.value)
        }
    }

    fun showClicked() {
        _liveData.postValue(AppState.Translation)
    }

    fun rememberClicked() {
        coroutineScope.launch {
            card?.let { card ->
                card.countRepeat++
                card.nextDateRepeating = addDayToDate(Date(), countingDays(card.countRepeat))
                repository.save(card)
            }
            getCard()
        }
    }

    private fun countingDays(count: Int) = count * 2 + 1

    private fun addDayToDate(date: Date, days: Int) =
        Date.from(date.toInstant().plus(days.toLong(), ChronoUnit.DAYS))

    fun notRememberClicked() {
        coroutineScope.launch {
            card?.let { card ->
                card.countRepeat = -1
                card.nextDateRepeating = Date()
                repository.save(card)
            }
            getCard()
        }
    }

    companion object {
        private const val TAG = "CardRepeatingViewModel"
    }

    sealed class AppState {
        class Success(val card: Card) : AppState()
        object NoCard : AppState()
        object Translation : AppState()
        object Loading : AppState()
    }
}