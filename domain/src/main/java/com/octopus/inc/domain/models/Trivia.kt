package com.octopus.inc.domain.models

data class Trivia(
    val text: String,
    val found: Boolean,
    val number: Int,
    val type: String,
    val date: String
)