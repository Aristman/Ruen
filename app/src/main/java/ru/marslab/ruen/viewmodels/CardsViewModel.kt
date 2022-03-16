package ru.marslab.ruen.viewmodels

import android.app.Application
import android.util.Log

class CardsViewModel(application: Application) : BaseViewModel(application) {
    override fun handleError(e: Throwable) {
        Log.e(TAG, "handleError: ${e.message}", e)
    }

    companion object {
        private const val TAG = "CardsViewModel"
    }
}