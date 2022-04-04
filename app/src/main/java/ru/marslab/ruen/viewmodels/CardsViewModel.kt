package ru.marslab.ruen.viewmodels

import android.util.Log
import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.marslab.ruen.Card
import ru.marslab.ruen.data.repositories.ICardRepository
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val repository: ICardRepository
) : BaseViewModel() {

    private val liveData = MutableLiveData<ViewState>()

    fun getLiveData(): LiveData<ViewState> = liveData

    override fun handleError(e: Throwable) {
        Log.e(TAG, "handleError: ${e.message}", e)
    }

    fun updateData() {
        coroutineScope.launch {
            liveData.postValue(ViewState.Loading)
            var cardsList: List<Card>? = null
            repository.get().collect {
                cardsList = it
                liveData.postValue(ViewState.Success(cardsList!!))
            }
        }
    }

    fun startRepeatingClicked() {
        liveData.postValue(ViewState.CardRepeating)
    }

    companion object {
        private const val TAG = "CardsViewModel"
    }

    sealed class ViewState {
        data class Success(val cards: List<Card>) : ViewState()
        data class Error(val error: Throwable) : ViewState()
        object Loading : ViewState()
        object CardRepeating : ViewState()
    }
}