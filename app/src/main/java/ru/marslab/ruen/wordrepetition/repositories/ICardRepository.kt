package ru.marslab.ruen.wordrepetition.repositories

import kotlinx.coroutines.flow.Flow
import ru.marslab.ruen.wordrepetition.domain.Card

interface ICardRepository {
    suspend fun save(card: Card)
    suspend fun get(): Flow<List<Card>>
    suspend fun getCardForRepeating(): Card?
}
