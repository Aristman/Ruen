package ru.marslab.ruen.viewmodels

import android.app.Application
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.marslab.ruen.Card
import ru.marslab.ruen.data.repositories.CardRepository
import ru.marslab.ruen.data.repositories.ICardRepository
import ru.marslab.ruen.data.repositories.room.DataBaseBuilder
import ru.marslab.ruen.utilities.TTSFactory

class CardRepeatingViewModel(application: Application) : BaseViewModel(application) {
    private val _liveData = MutableLiveData<AppState>()
    private val _repository: ICardRepository =
        CardRepository(DataBaseBuilder(application.applicationContext).getDataBase())
    private var _cardsList: MutableList<Card>? = null
    private val tts = TTSFactory(application.applicationContext) {}.getInstance()

    val liveData: LiveData<AppState> = _liveData
    override fun handleError(e: Throwable) {
        _liveData.postValue(AppState.Error(e))
    }

    override fun onCleared() {
        super.onCleared()
        tts.stop()
        tts.shutdown()
    }

    fun init() {
        coroutineScope.launch {
            _liveData.postValue(AppState.Loading)
            var cards: List<Card>? = null
            launch(Dispatchers.IO) {
                cards = _repository.getCardsForRepeating()
            }.join()
            cards?.let {
                _cardsList = it.toMutableList()
            }
            getCard()
        }
    }

    fun getCard() {
        if (_cardsList.isNullOrEmpty()) {
            _liveData.postValue(AppState.NoCard)
        } else {
            _liveData.postValue(AppState.Success(_cardsList!![0]))
        }
    }

    fun speechClicked() {
        if (!_cardsList.isNullOrEmpty()) {
            tts.speak(_cardsList!![0].value, TextToSpeech.QUEUE_FLUSH, null)
        }
    }

    sealed class AppState {
        class Success(val card: Card) : AppState()
        object NoCard : AppState()
        class Error(val error: Throwable) : AppState()
        object Loading : AppState()
    }
}