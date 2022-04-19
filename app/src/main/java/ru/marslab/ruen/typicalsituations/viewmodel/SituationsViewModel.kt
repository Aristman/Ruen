package ru.marslab.ruen.typicalsituations.viewmodel

import ru.marslab.ruen.core.presentation.BaseViewModel
import ru.marslab.ruen.typicalsituations.model.Situation
import ru.marslab.ruen.typicalsituations.model.SituationsRepository
import ru.marslab.ruen.typicalsituations.model.SituationsRepositoryImpl

data class SituationState(
    val situations: List<Situation> = emptyList()
)

class SituationsViewModel(
    private val situationsRepository: SituationsRepository = SituationsRepositoryImpl()
) : BaseViewModel<SituationState>(SituationState()) {
    init {
        launch {
            setData(SituationState(situationsRepository.getSituations()))
        }
    }
}
