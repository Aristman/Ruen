package ru.marslab.ruen.data.repositories

import ru.marslab.ruen.Translation
import ru.marslab.ruen.data.repositories.room.entities.RoomTranslation

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