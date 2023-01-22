package com.octopus.inc.network.models

data class TriviaRetrofitEntity(
    val text: String,
    val found: Boolean,
    val number: Int,
    val type: String,
    val date: String
)