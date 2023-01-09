package com.octopus.inc.data.room

import androidx.room.*
import com.octopus.inc.data.models.TriviaEntity

@Dao
interface TriviaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTrivia(note: TriviaEntity)

    @Query("SELECT * FROM trivia_table ORDER BY date_of_addition")
    suspend fun getTriviaList(): List<TriviaEntity>

    @Query("SELECT * FROM trivia_table WHERE id=:triviaId ")
    suspend fun getTrivia(triviaId: String): TriviaEntity
}