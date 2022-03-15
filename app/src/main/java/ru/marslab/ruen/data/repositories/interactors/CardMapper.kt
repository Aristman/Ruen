package ru.marslab.ruen.data.repositories.interactors

import ru.marslab.ruen.Card
import ru.marslab.ruen.data.repositories.room.entities.RoomCard

object CardMapper {
    fun convertCard(card: Card) =
        RoomCard(
            card.id,
            card.value,
            card.transcription,
        )

    fun convertRoomCard(card:RoomCard) =
        Card(
            card.id,
            card.value,
            card.transcription
        )
}