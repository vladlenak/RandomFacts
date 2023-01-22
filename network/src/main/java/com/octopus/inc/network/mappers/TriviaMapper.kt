package com.octopus.inc.network.mappers

import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.network.models.TriviaRetrofitEntity

class TriviaMapper: EntityMapper<TriviaRetrofitEntity, Trivia> {
    override fun mapFromEntity(type: TriviaRetrofitEntity): Trivia {
        return Trivia(
            text = type.text,
            found = type.found,
            number = type.number,
            type = type.type,
            date = type.date
        )
    }

    override fun mapToEntity(type: Trivia): TriviaRetrofitEntity {
        return TriviaRetrofitEntity(
            text = type.text,
            found = type.found,
            number = type.number,
            type = type.type,
            date = type.date
        )
    }
}