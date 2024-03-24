package com.example.speechnotespro.data

import com.example.speechnotespro.model.Note
import com.example.speechnotespro.db.NoteDao
import kotlinx.coroutines.flow.Flow

// Repository class to handle data operations
class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: Flow<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun update(note: Note) {
        noteDao.update(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}
