package com.octopus.inc.randomfacts.di

import com.octopus.inc.domain.repository.TriviaRepository
import com.octopus.inc.domain.usecases.GetTriviaListUseCase
import com.octopus.inc.domain.usecases.GetTriviaUseCase
import com.octopus.inc.domain.usecases.SaveTriviaUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetTriviaListUseCase(triviaRepository: TriviaRepository): GetTriviaListUseCase {
        return GetTriviaListUseCase(triviaRepository = triviaRepository)
    }

    @Provides
    fun provideGetTriviaUseCase(triviaRepository: TriviaRepository): GetTriviaUseCase {
        return GetTriviaUseCase(triviaRepository = triviaRepository)
    }

    @Provides
    fun provideSaveTriviaUseCase(triviaRepository: TriviaRepository): SaveTriviaUseCase {
        return SaveTriviaUseCase(triviaRepository = triviaRepository)
    }
}