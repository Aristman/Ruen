package ru.marslab.ruen.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    protected val coroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob() + CoroutineExceptionHandler{ _, throwable->
        handleError(throwable)
    })

    abstract fun handleError(e: Throwable)

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }

    protected fun cancelJob(){
        coroutineScope.coroutineContext.cancelChildren()
    }
}