package com.octopus.inc.network.mappers

interface EntityMapper<E, D> {
    fun mapFromEntity(type: E): D
    fun mapToEntity(type: D): E
}