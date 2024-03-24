package com.example.speechnotespro.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Note entity class
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val category: String,
    val content: String
)
