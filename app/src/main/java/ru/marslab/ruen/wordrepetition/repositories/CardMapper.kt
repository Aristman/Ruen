package ru.marslab.ruen.wordrepetition.repositories

import ru.marslab.ruen.wordrepetition.domain.Card
import ru.marslab.ruen.data.room.entities.RoomCard

object CardMapper {
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