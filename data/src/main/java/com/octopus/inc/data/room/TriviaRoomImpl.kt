package com.octopus.inc.data.room

import com.octopus.inc.data.models.TriviaRoomEntity
import javax.inject.Inject

class TriviaRoomImpl @Inject constructor(private val noteDao: TriviaDao): TriviaRoom {
    override suspend fun insertTrivia(triviaEntity: TriviaRoomEntity) {
        noteDao.insertTrivia(triviaEntity)
    }

    override suspend fun getTriviaList(): List<TriviaRoomEntity> {
        return noteDao.getTriviaList()
    }

    override suspend fun getTrivia(triviaId: String): TriviaRoomEntity {
        return noteDao.getTrivia(triviaId)
    }
}