package com.octopus.inc.domain.usecases

import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.domain.repository.TriviaRoomRepository

class GetTriviaListFromRoomUseCase(private val triviaRepository: TriviaRoomRepository) {
    suspend fun execute(): List<Trivia> {
        return triviaRepository.getTriviaList()
    }
}