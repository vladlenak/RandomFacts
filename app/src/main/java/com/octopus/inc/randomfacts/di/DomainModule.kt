package com.octopus.inc.randomfacts.di

import com.octopus.inc.domain.repository.TriviaRoomRepository
import com.octopus.inc.domain.repository.TriviaRetrofitRepository
import com.octopus.inc.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetTriviaListUseCase(triviaRepository: TriviaRoomRepository): GetTriviaListFromRoomUseCase {
        return GetTriviaListFromRoomUseCase(triviaRepository = triviaRepository)
    }

    @Provides
    fun provideGetTriviaUseCase(triviaRepository: TriviaRoomRepository): GetTriviaFromRoomUseCase {
        return GetTriviaFromRoomUseCase(triviaRepository = triviaRepository)
    }

    @Provides
    fun provideSaveTriviaUseCase(triviaRepository: TriviaRoomRepository): SaveTriviaToRoomUseCase {
        return SaveTriviaToRoomUseCase(triviaRepository = triviaRepository)
    }

    @Provides
    fun provideGetTriviaFromRetrofitUseCase(triviaRetrofitRepository: TriviaRetrofitRepository): GetTriviaFromRetrofitUseCase {
        return GetTriviaFromRetrofitUseCase(triviaRetrofitRepository = triviaRetrofitRepository)
    }

    @Provides
    fun provideGetRandomTriviaFromRetrofitUseCase(triviaRetrofitRepository: TriviaRetrofitRepository): GetRandomTriviaFromRetrofitUseCase {
        return GetRandomTriviaFromRetrofitUseCase(triviaRetrofitRepository = triviaRetrofitRepository)
    }
}