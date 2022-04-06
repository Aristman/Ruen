package ru.marslab.ruen.wordrepetition.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.marslab.ruen.wordrepetition.domain.Card
import ru.marslab.ruen.wordrepetition.repositories.ICardRepository
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
            repository.get().collect {
                liveData.postValue(ViewState.Success(it))
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