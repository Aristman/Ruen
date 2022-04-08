package ru.marslab.ruen.typicalsituations.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.marslab.ruen.typicalsituations.model.SituationsRepository
import ru.marslab.ruen.typicalsituations.model.SituationsRepositoryImpl
import ru.marslab.ruen.wordrepetition.viewmodels.BaseViewModel

class SituationsViewModel(
    private val _liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val situationsRepository: SituationsRepository = SituationsRepositoryImpl()
) : BaseViewModel() {

    val liveDataToObserve: LiveData<AppState>
        get() = _liveDataToObserve

    fun getSituations() {
        _liveDataToObserve.postValue(AppState.Loading)
        viewModelScope.launch {
            _liveDataToObserve.postValue(AppState.Success(situationsRepository.getSituations()))
        }
    }

    override fun handleError(e: Throwable) {
        _liveDataToObserve.postValue(AppState.Error(e))
    }
}