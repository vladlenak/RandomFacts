package com.octopus.inc.domain.usecases

import com.octopus.inc.domain.models.TriviaModel
import com.octopus.inc.domain.repository.TriviaRepository

class GetTriviaListUseCase(private val triviaRepository: TriviaRepository) {
    suspend fun execute(): List<TriviaModel> {
        return triviaRepository.getTriviaList()
    }
}