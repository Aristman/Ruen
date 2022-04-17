package ru.marslab.ruen.typicalsituations.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.marslab.ruen.typicalsituations.model.SituationsRepository
import ru.marslab.ruen.typicalsituations.model.SituationsRepositoryImpl

class SituationsViewModel(
    private val _liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val situationsRepository: SituationsRepository = SituationsRepositoryImpl()
) : ViewModel() {

    val liveDataToObserve: LiveData<AppState>
        get() = _liveDataToObserve

    fun getSituations() {
        _liveDataToObserve.postValue(AppState.Loading)
        viewModelScope.launch {
            _liveDataToObserve.postValue(AppState.Success(situationsRepository.getSituations()))
        }
    }
}
