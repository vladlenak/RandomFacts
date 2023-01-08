package com.octopus.inc.domain.repository

import com.octopus.inc.domain.models.TriviaModel

interface TriviaRepository {
    suspend fun insertTrivia(trivia: TriviaModel)
    suspend fun getTriviaById(id: Int): TriviaModel
    suspend fun getTriviaList(): List<TriviaModel>
}