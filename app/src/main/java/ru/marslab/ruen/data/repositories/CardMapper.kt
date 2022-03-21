package ru.marslab.ruen.data.repositories

import ru.marslab.ruen.Card
import ru.marslab.ruen.data.repositories.room.entities.RoomCard

object CardMapper {
    fun toRoomCard(card: Card) =
        RoomCard(card.id, card.value, card.transcription, card.imageUrl, card.nextDateRepeating)

    fun toCard(roomCard: RoomCard) =
        Card(
            roomCard.id,
            roomCard.value,
            transcription = roomCard.transcription,
            imageUrl = roomCard.imageUrl,
            nextDateRepeating = roomCard.nextDateRepeating
        )
}