package com.octopus.inc.domain.usecases

import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.domain.repository.TriviaRoomRepository

class SaveTriviaToRoomUseCase(private val triviaRepository: TriviaRoomRepository) {
    suspend fun execute(triviaModel: Trivia) {
        triviaRepository.insertTrivia(triviaModel)
    }
}