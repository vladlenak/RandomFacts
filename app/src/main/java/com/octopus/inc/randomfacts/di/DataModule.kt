package com.octopus.inc.randomfacts.di

import android.content.Context
import androidx.room.Room
import com.octopus.inc.data.repository.TriviaRepositoryImpl
import com.octopus.inc.data.room.TriviaDao
import com.octopus.inc.data.room.TriviaRoom
import com.octopus.inc.data.room.TriviaRoomDatabase
import com.octopus.inc.data.room.TriviaRoomImpl
import com.octopus.inc.domain.repository.TriviaRoomRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideTriviaRepositoryImpl(triviaRoomImpl: TriviaRoomImpl): TriviaRoomRepository {
        return TriviaRepositoryImpl(triviaRoomImpl)
    }

    @Provides
    fun provideTriviaRoomImpl(triviaDao: TriviaDao): TriviaRoom {
        return TriviaRoomImpl(triviaDao)
    }

    @Provides
    fun provideTriviaRoomDatabase(@ApplicationContext context: Context): TriviaRoomDatabase {
        return Room.databaseBuilder(
            context,
            TriviaRoomDatabase::class.java,
            "trivia_database"
        ).build()
    }

    @Provides
    fun provideTriviaDao(triviaRoomDatabase: TriviaRoomDatabase): TriviaDao {
        return triviaRoomDatabase.noteDao()
    }
}