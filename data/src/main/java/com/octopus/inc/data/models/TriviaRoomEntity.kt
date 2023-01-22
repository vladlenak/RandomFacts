package com.octopus.inc.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trivia_table")
data class TriviaRoomEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val number: Int,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "found")
    val found: Boolean,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "date")
    val date: String,
)