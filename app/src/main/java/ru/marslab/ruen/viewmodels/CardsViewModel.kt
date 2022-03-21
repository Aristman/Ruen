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
import ru.marslab.ruen.data.repositories.room.DataBaseBuilder

class CardsViewModel(application: Application) : BaseViewModel(application) {

    private val repository =
        CardRepository(DataBaseBuilder(application.applicationContext).getDataBase())
    private val liveData = MutableLiveData<ViewState>()

    fun getLiveData(): LiveData<ViewState> = liveData

    override fun handleError(e: Throwable) {
        Log.e(TAG, "handleError: ${e.message}", e)
    }

    fun updateData() {
        coroutineScope.launch {
            liveData.postValue(ViewState.Loading)
            var cardsList: List<Card>?
            withContext(Dispatchers.IO) {
                cardsList = repository.get()
            }
            cardsList?.let {
                liveData.postValue(ViewState.Success(it))
            }
        }
    }

    companion object {
        private const val TAG = "CardsViewModel"
    }

    sealed class ViewState {
        data class Success(val cards: List<Card>) : ViewState()
        data class Error(val error: Throwable) : ViewState()
        object Loading : ViewState()
    }
}