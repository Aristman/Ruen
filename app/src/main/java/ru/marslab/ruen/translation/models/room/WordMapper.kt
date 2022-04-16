package ru.marslab.ruen.translation.models.room

import ru.marslab.ruen.data.room.entities.RoomWord
import ru.marslab.ruen.translation.beans.Word
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WordMapper @Inject constructor() {
    fun toRoomWord(word: Word) = RoomWord(word.id, word.value, word.translation)
    fun toWord(roomWord: RoomWord) = Word(roomWord.id, roomWord.value, roomWord.translation)
}
