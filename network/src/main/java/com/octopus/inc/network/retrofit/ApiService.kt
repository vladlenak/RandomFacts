package com.octopus.inc.network.retrofit

import com.octopus.inc.network.EndPoints
import com.octopus.inc.network.models.TriviaRetrofitEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(EndPoints.RANDOM_TRIVIA_URL)
    suspend fun getRandomTrivia() : Response<TriviaRetrofitEntity>

    @GET("#{triviaId}/trivia")
    suspend fun getTriviaById(@Path("triviaId") triviaId: String) : Response<Any>
}