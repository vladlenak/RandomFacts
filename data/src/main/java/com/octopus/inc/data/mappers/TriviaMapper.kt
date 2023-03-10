package com.octopus.inc.data.mappers

import com.octopus.inc.data.models.TriviaRoomEntity
import com.octopus.inc.domain.models.Trivia

class TriviaMapper: EntityMapper<TriviaRoomEntity, Trivia> {
    override fun mapFromEntity(type: TriviaRoomEntity): Trivia {
        return Trivia(
            text = type.text,
            found = type.found,
            number = type.number,
            type = type.type,
            date = type.date
        )
    }

    override fun mapToEntity(type: Trivia): TriviaRoomEntity {
        return TriviaRoomEntity(
            text = type.text,
            found = type.found,
            number = type.number,
            type = type.type,
            date = type.date
        )
    }
}