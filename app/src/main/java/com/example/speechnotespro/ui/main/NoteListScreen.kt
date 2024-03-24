package com.example.speechnotespro.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NoteListScreen(noteViewModel: NoteViewModel, navigateToAddNote: () -> Unit) {
    val allNotes by noteViewModel.allNotes.collectAsState(emptyList())

    Column {
        // Display list of notes
        LazyColumn {
            items(allNotes) { note ->
                NoteItem(note = note)
            }
        }

        // Button to navigate to AddNoteScreen
        Button(
            onClick = navigateToAddNote,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
        ) {
            Text("Add Note")
        }
    }
}
