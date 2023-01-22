package com.octopus.inc.domain.usecases

import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.domain.repository.TriviaRetrofitRepository

class GetRandomTriviaFromRetrofitUseCase(private val triviaRetrofitRepository: TriviaRetrofitRepository) {
    suspend fun execute(): Trivia {
        return triviaRetrofitRepository.getRandomTrivia()
    }
}