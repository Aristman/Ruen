package ru.marslab.ruen.core.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

private const val FLOW_ERROR_TAG = "Execute flow error"

abstract class BaseViewModel<S>(initState: S) : ViewModel() {
    private val _event: Channel<Event> = Channel()
    val event: Flow<Event>
        get() = _event.receiveAsFlow()

    private val _state: MutableStateFlow<S> = MutableStateFlow(initState)
    val state: Flow<S>
        get() = _state.asStateFlow()

    open fun errorHandler(error: Throwable) {
        Log.d(FLOW_ERROR_TAG, error.message.orEmpty(), error)
    }

    fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch {
            block.invoke(this)
        }
    }

    protected fun setData(data: S) {
        _state.tryEmit(data)
    }

    protected fun sendEvent(event: Event) {
        launch {
            _event.send(event)
        }
    }

    protected fun clearEvent() {
        launch {
            _event.send(EmptyEvent)
        }
    }

    fun stateFlowHandler(
        flowResult: (data: S) -> Unit
    ) {
        launch {
            state
                .onStart {
                    sendEvent(ViewEvent.Loading)
                }
                .catch {
                    errorHandler(it)
                    sendEvent(ViewEvent.Error(it))
                }
                .collect {
                    flowResult(it)
                }
        }
    }
}
