package ru.marslab.ruen.core.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseViewModel<S, E>(initState: S) : ViewModel() {
    private val _event: Channel<E> = Channel()
    val event: Flow<E>
        get() = _event.receiveAsFlow()

    private val _state: MutableStateFlow<S> = MutableStateFlow(initState)
    val state: Flow<S>
        get() = _state.asStateFlow()
}

interface BaseState

interface BaseEvent
