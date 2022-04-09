package ru.marslab.ruen.wordrepetition.repositories

import kotlinx.coroutines.flow.map
import ru.marslab.ruen.wordrepetition.domain.Card
import ru.marslab.ruen.data.room.RuenDatabase
import ru.marslab.ruen.data.room.entities.RoomCard
import java.util.*

class CardRepository(
    private val db: RuenDatabase,
    private val cardMapper: CardMapper
) : ICardRepository {
    override suspend fun save(card: Card) {
        val roomCard = cardMapper.toRoomCard(card)
        card.id = db.cardDao().save(roomCard)
        val roomTranslations = card.translations?.map { translation ->
            translation.cardId = card.id
            TranslationMapper.toRoomTranslation(translation)
        }
        roomTranslations?.let {
            db.translateDao().save(it)
        }
    }

    override suspend fun get() = db.cardDao().get()
        .map { list -> list.map { cardMapper.toCard(it) } }


    override suspend fun getCardForRepeating(): Card? {
        val roomCard = db.cardDao().getCardForRepeating(Date())
        return roomCard?.let { mapRoomCard(it) }
    }

    private suspend fun mapRoomCard(roomCard: RoomCard): Card {
        val translationsList =
            db.translateDao().get(roomCard.id!!)
                .map { TranslationMapper.toTranslation(it) }
                .toMutableList()
        return cardMapper.toCard(roomCard).apply { translations = translationsList }
    }
}