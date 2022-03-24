package ru.marslab.ruen.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.marslab.ruen.Card
import ru.marslab.ruen.data.repositories.CardRepository
import ru.marslab.ruen.data.repositories.ICardRepository
import ru.marslab.ruen.data.repositories.room.DataBaseBuilder
import ru.marslab.ruen.utilities.ITextToSpeech
import ru.marslab.ruen.utilities.TTS
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*

class CardRepeatingViewModel(application: Application) : BaseViewModel(application) {
    private val _liveData = MutableLiveData<AppState>()
    private val _repository: ICardRepository =
        CardRepository(DataBaseBuilder(application.applicationContext).getDataBase())
    private val tts: ITextToSpeech = TTS(application.applicationContext)
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
            card = _repository.getCardForRepeating()
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
                _repository.save(card)
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
                _repository.save(card)
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