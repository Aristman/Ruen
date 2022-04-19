package ru.marslab.ruen.core.presentation

sealed class ViewState<out D, out E> {
    object Init : ViewState<Nothing, Nothing>()
    data class Success<out D>(val data: D) : ViewState<D, Nothing>()
    data class Error<out E>(val error: E) : ViewState<Nothing, E>()
    data class Loading(val progress: Float?) : ViewState<Nothing, Nothing>()
}
