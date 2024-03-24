package com.example.speechnotespro.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.speechnotespro.model.Note

@Composable
fun AddNoteScreen(onNoteAdded: (Note) -> Unit) {
    var category by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // Category input
        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category") }
        )

        // Content input
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") }
        )

        // Button to add note
        Button(
            onClick = {
                val newNote = Note(
                    category = category,
                    content = content
                )
                onNoteAdded(newNote)
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.End)
        ) {
            Text("Add Note")
        }
    }
}
