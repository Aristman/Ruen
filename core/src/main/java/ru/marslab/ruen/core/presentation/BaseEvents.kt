package ru.marslab.ruen.core.presentation

interface Event

object EmptyEvent : Event

sealed class ViewEvent : Event {
    object Loading : ViewEvent()
    data class Error(val error: Throwable) : ViewEvent()
}
