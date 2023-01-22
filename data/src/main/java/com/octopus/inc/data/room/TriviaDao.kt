package com.octopus.inc.data.room

import androidx.room.*
import com.octopus.inc.data.models.TriviaRoomEntity

@Dao
interface TriviaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTrivia(note: TriviaRoomEntity)

    @Query("SELECT * FROM trivia_table ORDER BY date")
    suspend fun getTriviaList(): List<TriviaRoomEntity>

    @Query("SELECT * FROM trivia_table WHERE id=:triviaId ")
    suspend fun getTrivia(triviaId: String): TriviaRoomEntity
}