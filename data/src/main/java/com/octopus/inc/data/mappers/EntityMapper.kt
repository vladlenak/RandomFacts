package com.octopus.inc.data.mappers

interface EntityMapper<E, D> {
    fun mapFromEntity(type: E): D
    fun mapToEntity(type: D): E
}