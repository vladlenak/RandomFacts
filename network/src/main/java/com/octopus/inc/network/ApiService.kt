package com.octopus.inc.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(EndPoints.RANDOM_TRIVIA_URL)
    suspend fun randomTrivia() : Response<Any>
}