package ru.marslab.ruen.wordrepetition.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel :
    ViewModel() {
    protected val coroutineScope =
        CoroutineScope(Dispatchers.IO + SupervisorJob() + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    abstract fun handleError(e: Throwable)

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }

    protected fun cancelJob() {
        coroutineScope.coroutineContext.cancelChildren()
    }
}