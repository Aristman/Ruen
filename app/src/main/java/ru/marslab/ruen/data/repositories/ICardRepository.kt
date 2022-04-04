package ru.marslab.ruen.data.repositories

import kotlinx.coroutines.flow.Flow
import ru.marslab.ruen.Card

interface ICardRepository {
    suspend fun save(card: Card)
    suspend fun get(): Flow<List<Card>>
    suspend fun getCardForRepeating(): Card?
}