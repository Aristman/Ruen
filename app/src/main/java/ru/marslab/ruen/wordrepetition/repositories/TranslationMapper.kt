package ru.marslab.ruen.wordrepetition.repositories

import ru.marslab.ruen.wordrepetition.domain.Translation
import ru.marslab.ruen.data.room.entities.RoomTranslation

object TranslationMapper {
    fun toRoomTranslation(translation: Translation) =
        RoomTranslation(
            translation.id,
            translation.value,
            translation.cardId
        )

    fun toTranslation(roomTranslation: RoomTranslation) =
        Translation(
            roomTranslation.id,
            roomTranslation.value,
            roomTranslation.cardId,
        )
}