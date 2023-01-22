package com.octopus.inc.domain.usecases

import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.domain.repository.TriviaRoomRepository

class GetTriviaFromRoomUseCase(private val triviaRepository: TriviaRoomRepository) {
    suspend fun execute(id: Int): Trivia {
        return triviaRepository.getTriviaById(id)
    }
}