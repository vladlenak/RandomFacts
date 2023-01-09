package com.octopus.inc.domain.usecases

import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.domain.repository.TriviaRepository

class SaveTriviaUseCase(private val triviaRepository: TriviaRepository) {
    suspend fun execute(triviaModel: Trivia) {
        triviaRepository.insertTrivia(triviaModel)
    }
}