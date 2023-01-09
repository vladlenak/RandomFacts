package com.octopus.inc.domain.usecases

import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.domain.repository.TriviaRepository

class GetTriviaUseCase(private val triviaRepository: TriviaRepository) {
    suspend fun execute(id: Int): Trivia {
        return triviaRepository.getTriviaById(id)
    }
}