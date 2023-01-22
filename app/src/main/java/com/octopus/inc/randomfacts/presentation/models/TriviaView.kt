package com.octopus.inc.randomfacts.presentation.models

data class TriviaView(
    val text: String,
    val found: Boolean,
    val number: Int,
    val type: String,
    val date: String
)