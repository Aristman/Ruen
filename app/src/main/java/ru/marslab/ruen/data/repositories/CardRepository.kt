package ru.marslab.ruen.data.repositories

import ru.marslab.ruen.Card
import ru.marslab.ruen.data.repositories.room.DataBaseBuilder
import ru.marslab.ruen.data.repositories.room.RuenDatabase
import ru.marslab.ruen.data.repositories.room.entities.RoomCard
import java.time.LocalDate
import java.util.*

class CardRepository(
    private val db: RuenDatabase
) : ICardRepository {
    override suspend fun save(card: Card) {
        val roomCard = CardMapper.toRoomCard(card)
        card.id = db.cardDao().save(roomCard)
        val roomTranslations = card.translations?.map { translation ->
            translation.cardId = card.id
            TranslationMapper.toRoomTranslation(translation)
        }
        roomTranslations?.let {
            db.translateDao().save(it)
        }
    }

    override suspend fun get(): List<Card> {
        val roomCards = db.cardDao().get()
        return mapRoomCards(roomCards)
    }

    override suspend fun getCardsForRepeating(): List<Card> {
        val roomCards = db.cardDao().getCardsForRepeating(Date())
        return mapRoomCards(roomCards)
    }

    private suspend fun mapRoomCards(roomCards: List<RoomCard>) = roomCards.map { roomCard ->
        val translationsList =
            db.translateDao().get(roomCard.id!!)
                .map { TranslationMapper.toTranslation(it) }
                .toMutableList()

        CardMapper.toCard(roomCard).apply { translations = translationsList }
    }
}