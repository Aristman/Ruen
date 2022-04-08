package ru.marslab.ruen.typicalsituations.model

interface SituationsRepository {
    suspend fun getSituations(): List<Situations>
}