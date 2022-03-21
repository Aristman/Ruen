package ru.marslab.ruen.viewmodels

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import ru.marslab.ruen.Card
import ru.marslab.ruen.Translation
import ru.marslab.ruen.data.repositories.CardRepository
import ru.marslab.ruen.data.repositories.ICardRepository
import ru.marslab.ruen.data.repositories.room.DataBaseBuilder

class CardAddViewModel(
    application: Application
) : BaseViewModel(application) {
    private val repository =
        CardRepository(DataBaseBuilder(application.applicationContext).getDataBase())
    private val liveData = MutableLiveData<Card>()
    private var card: Card? = null

    fun getLiveData(): LiveData<Card> = liveData

    fun init(card: Card) {
        this.card = card
        liveData.postValue(card)
    }

    fun save(translations: List<String>, customTranslate: String) {
        card?.let {
            it.translations?.apply {
                clear()
                addAll(translations.map { return@map Translation(value = it) })
            }
            val customTranslateTrimed = customTranslate.trim()
            if (customTranslateTrimed.isNotEmpty()) {
                it.translations?.add(Translation(value = customTranslate))
            }
            coroutineScope.launch(Dispatchers.IO) {
                repository.save(it)
            }
        }
    }

    override fun handleError(e: Throwable) {
        Log.e(TAG, "handleError: ${e.message}", e)
    }

    companion object {
        private const val TAG = "CardAddViewModel"
    }
}