package com.octopus.inc.data.room

import com.octopus.inc.data.models.TriviaRoomEntity

interface TriviaRoom {
    suspend fun insertTrivia(triviaEntity: TriviaRoomEntity)
    suspend fun getTriviaList(): List<TriviaRoomEntity>
    suspend fun getTrivia(triviaId: String): TriviaRoomEntity
}