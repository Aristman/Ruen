package ru.marslab.ruen.typicalsituations.viewmodel

import ru.marslab.ruen.typicalsituations.model.Situations

sealed class AppState {
    data class Success(val situations: List<Situations>) : AppState()
    class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
