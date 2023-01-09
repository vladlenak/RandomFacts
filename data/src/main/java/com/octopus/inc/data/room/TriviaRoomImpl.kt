package com.octopus.inc.data.room

import com.octopus.inc.data.models.TriviaEntity
import javax.inject.Inject

class TriviaRoomImpl @Inject constructor(private val noteDao: TriviaDao): TriviaRoom {
    override suspend fun insertTrivia(triviaEntity: TriviaEntity) {
        noteDao.insertTrivia(triviaEntity)
    }

    override suspend fun getTriviaList(): List<TriviaEntity> {
        return noteDao.getTriviaList()
    }

    override suspend fun getTrivia(triviaId: String): TriviaEntity {
        return noteDao.getTrivia(triviaId)
    }
}