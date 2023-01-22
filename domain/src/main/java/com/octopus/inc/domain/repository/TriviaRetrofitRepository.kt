package com.octopus.inc.domain.repository

import com.octopus.inc.domain.models.Trivia

interface TriviaRetrofitRepository {
    suspend fun getTriviaById(id: Int): Trivia
    suspend fun getRandomTrivia(): Trivia
}