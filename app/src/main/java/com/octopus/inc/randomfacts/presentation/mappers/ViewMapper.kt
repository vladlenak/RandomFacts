package com.octopus.inc.randomfacts.presentation.mappers

interface ViewMapper<E, D> {
    fun mapFromEntity(type: E): D
    fun mapToEntity(type: D): E
}