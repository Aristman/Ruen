package ru.marslab.ruen.wordrepetition.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.marslab.ruen.wordrepetition.domain.Card
import ru.marslab.ruen.wordrepetition.domain.Translation
import ru.marslab.ruen.wordrepetition.repositories.ICardRepository
import javax.inject.Inject

@HiltViewModel
class CardAddViewModel @Inject constructor(
    private val repository: ICardRepository
) : BaseViewModel() {

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