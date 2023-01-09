package com.octopus.inc.data.mappers

import com.octopus.inc.data.models.TriviaEntity
import com.octopus.inc.domain.models.Trivia

class TriviaMapper: EntityMapper<TriviaEntity, Trivia> {
    override fun mapFromEntity(type: TriviaEntity): Trivia {
        return Trivia(
            id = type.id,
            title = type.title,
            dateOfAddition = type.dateOfAddition
        )
    }

    override fun mapToEntity(type: Trivia): TriviaEntity {
        return TriviaEntity(
            id = type.id,
            title = type.title,
            dateOfAddition = type.dateOfAddition
        )
    }
}