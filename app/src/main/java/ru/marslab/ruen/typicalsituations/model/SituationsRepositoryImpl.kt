package ru.marslab.ruen.typicalsituations.model

class SituationsRepositoryImpl : SituationsRepository {
    override suspend fun getSituations(): List<Situations> {
        return getSituationsData()
    }
}
