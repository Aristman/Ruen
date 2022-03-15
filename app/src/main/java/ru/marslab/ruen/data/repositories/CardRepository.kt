package ru.marslab.ruen.data.repositories

import ru.marslab.ruen.Card

class CardRepository : ICardRepository {
    override fun save(card: Card) {
        println("VVV ${card.value}")
    }
}