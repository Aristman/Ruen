package ru.marslab.ruen.data.repositories

import ru.marslab.ruen.Card

interface ICardRepository {
    fun save(card: Card)
    fun get(): List<Card>
}