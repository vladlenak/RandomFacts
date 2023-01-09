package com.octopus.inc.data.repository

import com.octopus.inc.data.mappers.TriviaMapper
import com.octopus.inc.data.room.TriviaRoomImpl
import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.domain.repository.TriviaRepository

class TriviaRepositoryImpl(private val triviaRoomImpl: TriviaRoomImpl): TriviaRepository {
    override suspend fun insertTrivia(trivia: Trivia) {
        triviaRoomImpl.insertTrivia(TriviaMapper().mapToEntity(trivia))
    }

    override suspend fun getTriviaById(id: Int): Trivia {
        return TriviaMapper().mapFromEntity(triviaRoomImpl.getTrivia(id.toString()))
    }

    override suspend fun getTriviaList(): List<Trivia> {
        return triviaRoomImpl.getTriviaList().map { triviaEntity ->
            TriviaMapper().mapFromEntity(triviaEntity)
        }
    }
}