package com.octopus.inc.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.octopus.inc.data.models.TriviaEntity

@Database(entities = [TriviaEntity::class], version = 1, exportSchema = true)
abstract class TriviaRoomDatabase : RoomDatabase() {
    abstract fun noteDao(): TriviaDao
}