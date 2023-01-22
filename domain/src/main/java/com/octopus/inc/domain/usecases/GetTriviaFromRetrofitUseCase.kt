package com.octopus.inc.domain.usecases

import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.domain.repository.TriviaRetrofitRepository

class GetTriviaFromRetrofitUseCase(private val triviaRetrofitRepository: TriviaRetrofitRepository) {
    suspend fun execute(triviaId: Int): Trivia {
        return triviaRetrofitRepository.getTriviaById(triviaId)
    }
}