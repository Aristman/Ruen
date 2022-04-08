package ru.marslab.ruen.wordrepetition.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
) : ViewModel() {

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
            viewModelScope.launch(Dispatchers.IO) {
                repository.save(it)
            }
        }
    }

    companion object {
        private const val TAG = "CardAddViewModel"
    }
}