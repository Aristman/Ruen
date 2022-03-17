package ru.marslab.ruen.typicalsituations.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.marslab.ruen.typicalsituations.model.SituationsRepository
import ru.marslab.ruen.typicalsituations.model.SituationsRepositoryImpl

class SituationsViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val situationsRepository: SituationsRepository = SituationsRepositoryImpl()
) : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getSituations() {
        liveDataToObserve.postValue(AppState.Success(situationsRepository.getSituations()))
    }
}