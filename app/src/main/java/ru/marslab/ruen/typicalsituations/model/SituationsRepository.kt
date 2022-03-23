package ru.marslab.ruen.typicalsituations.model

interface SituationsRepository {
    fun getSituations(): List<Situations>
}