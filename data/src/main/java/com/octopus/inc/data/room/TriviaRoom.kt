package com.octopus.inc.data.room

import com.octopus.inc.data.models.TriviaEntity

interface TriviaRoom {
    suspend fun insertTrivia(triviaEntity: TriviaEntity)
    suspend fun getTriviaList(): List<TriviaEntity>
    suspend fun getTrivia(triviaId: String): TriviaEntity
}