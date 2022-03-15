package ru.marslab.ruen.data.repositories

import ru.marslab.ruen.Card
import ru.marslab.ruen.data.repositories.interactors.CardMapper
import ru.marslab.ruen.data.repositories.room.RuenDatabase

class CardRepository(private val database: RuenDatabase) : ICardRepository {
    override fun save(card: Card) {
        val roomCard = CardMapper.convertCard(card)
        database.cardDao().save(roomCard)
    }
}