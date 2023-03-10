package com.octopus.inc.domain.repository

import com.octopus.inc.domain.models.Trivia

interface TriviaRoomRepository {
    suspend fun insertTrivia(trivia: Trivia)
    suspend fun getTriviaById(id: Int): Trivia
    suspend fun getTriviaList(): List<Trivia>
}