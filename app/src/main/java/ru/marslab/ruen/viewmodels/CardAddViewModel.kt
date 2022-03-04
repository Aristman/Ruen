package ru.marslab.ruen.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.marslab.ruen.Card
import ru.marslab.ruen.Translation
import ru.marslab.ruen.data.repositories.CardRepository
import ru.marslab.ruen.data.repositories.ICardRepository

class CardAddViewModel(
    private val repository: ICardRepository = CardRepository()
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
            it.translations.apply {
                clear()
                addAll(translations.map { return@map Translation(value = it) })
            }
            val customTranslateTrimed = customTranslate.trim()
            if (customTranslateTrimed.length>0) {
                it.translations.add(Translation(value = customTranslate))
            }
            repository.save(it)
        }
    }
}