package com.octopus.inc.network.repository

import android.util.Log
import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.domain.repository.TriviaRetrofitRepository
import com.octopus.inc.network.mappers.TriviaMapper
import com.octopus.inc.network.models.TriviaRetrofitEntity

import com.octopus.inc.network.retrofit.ApiService

private const val TAG = "TriviaRetrofitRepositor"
class TriviaRetrofitRepositoryImpl(private val apiService: ApiService) : TriviaRetrofitRepository {
    override suspend fun getTriviaById(id: Int): Trivia {
        val _trivia = apiService.getTriviaById(id.toString())
        Log.d(TAG, "getTriviaById: $_trivia")
        val trivia = _trivia.message()

        return trivia?.let { trivia ->
            TriviaMapper().mapFromEntity(
                TriviaRetrofitEntity(
                    text = trivia,
                    found = false,
                    number = 1,
                    type = "",
                    date = ""
                )
            )
        } ?: Trivia(
            "",
            false,
            1,
            "",
            ""
        )
    }

    override suspend fun getRandomTrivia(): Trivia {
        val trivia = apiService.getRandomTrivia().body()

        return trivia?.let {
            TriviaMapper().mapFromEntity(it)
        } ?: Trivia(
            "",
            false,
            1,
            "",
            ""
        )
    }
}