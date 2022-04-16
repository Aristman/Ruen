package ru.marslab.ruen.wordrepetition.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.marslab.ruen.wordrepetition.domain.Card
import ru.marslab.ruen.wordrepetition.repositories.ICardRepository
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val repository: ICardRepository
) : ViewModel() {

    private val liveData = MutableLiveData<ViewState>()

    fun getLiveData(): LiveData<ViewState> = liveData

    fun updateData() {
        viewModelScope.launch {
            liveData.postValue(ViewState.Loading)
            withContext(Dispatchers.IO) {
                repository.get().collect {
                    withContext(Dispatchers.Main) {
                        liveData.postValue(ViewState.Success(it))
                    }
                }
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
