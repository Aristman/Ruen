package ru.marslab.ruen.typicalsituations.model

class SituationsRepositoryImpl : SituationsRepository {
    override fun getSituations(): List<Situations> {
        return getSituationsData()
    }
}