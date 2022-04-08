package ru.marslab.ruen.translation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.marslab.ruen.translation.models.Repository
import ru.marslab.ruen.translation.models.retrofit.beans.Word
import javax.inject.Inject

@HiltViewModel
class TranslationViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val liveData = MutableLiveData<AppState>()
    fun translate(query: String): LiveData<AppState> {
        viewModelScope.launch(Dispatchers.IO) {
            val words = repository.getTranslation(query)
            withContext(Dispatchers.Main) {
                if (words.size == 0) {
                    liveData.postValue(AppState.NotFound)
                    return@withContext
                }
                val word = words[0]
                liveData.postValue(AppState.Success(word))
            }
        }
        return liveData
    }
}

sealed class AppState {
    data class Success(val word: Word) : AppState()
    object NotFound : AppState()
    object Loading : AppState()
}
