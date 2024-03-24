package com.example.speechnotespro.ui.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.speechnotespro.model.Note

// Individual note item
@Composable
fun NoteItem(note: Note) {
    Text(text = note.content)
}
