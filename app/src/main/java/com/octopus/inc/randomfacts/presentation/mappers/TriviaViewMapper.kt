package com.octopus.inc.randomfacts.presentation.mappers

import com.octopus.inc.domain.models.Trivia
import com.octopus.inc.randomfacts.presentation.models.TriviaView

class TriviaViewMapper: ViewMapper<TriviaView, Trivia> {
    override fun mapFromEntity(type: TriviaView): Trivia {
        return Trivia(
            text = type.text,
            found = type.found,
            number = type.number,
            type = type.type,
            date = type.date
        )
    }

    override fun mapToEntity(type: Trivia): TriviaView {
        return TriviaView(
            text = type.text,
            found = type.found,
            number = type.number,
            type = type.type,
            date = type.date
        )
    }
}