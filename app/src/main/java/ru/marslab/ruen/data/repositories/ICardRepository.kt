package ru.marslab.ruen.data.repositories

import ru.marslab.ruen.Card

interface ICardRepository {
    suspend fun save(card: Card)
    suspend fun get(): List<Card>
    suspend fun getCardForRepeating(): Card?
}