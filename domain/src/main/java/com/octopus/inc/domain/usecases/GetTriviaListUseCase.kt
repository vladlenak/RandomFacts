package com.octopus.inc.domain.usecases

import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.domain.repository.TriviaRepository

class GetTriviaListUseCase(private val triviaRepository: TriviaRepository) {
    suspend fun execute(): List<Trivia> {
        return triviaRepository.getTriviaList()
    }
}