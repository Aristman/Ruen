package ru.marslab.ruen.wordrepetition.repositories

import ru.marslab.ruen.data.room.entities.RoomCard
import ru.marslab.ruen.wordrepetition.domain.Card
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardMapper @Inject constructor() {
    fun toRoomCard(card: Card) =
        RoomCard(
            card.id,
            card.value,
            card.transcription,
            card.imageUrl,
            card.nextDateRepeating,
            card.countRepeat
        )

    fun toCard(roomCard: RoomCard) =
        Card(
            roomCard.id,
            roomCard.value,
            transcription = roomCard.transcription,
            imageUrl = roomCard.imageUrl,
            nextDateRepeating = roomCard.nextDateRepeating,
            countRepeat = roomCard.countRepeat
        )
}
