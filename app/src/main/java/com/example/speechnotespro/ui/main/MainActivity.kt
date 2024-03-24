package com.example.speechnotespro.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.speechnotespro.ui.theme.SpeechNotesProTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: NoteViewModel by viewModels()
            val navController = rememberNavController()

            NavHost(navController, startDestination = "addNoteScreen") {
                composable("addNoteScreen") {
                    AddNoteScreen { note ->
                        viewModel.insert(note)
                        navController.navigate("noteListScreen")
                    }
                }
                composable("noteListScreen") {
                    NoteListScreen(
                        noteViewModel = viewModel,
                        navigateToAddNote = {
                            navController.navigate("addNoteScreen")
                        }
                    )
                }
            }
//            SpeechNotesProTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SpeechNotesProTheme {
        Greeting("Android")
    }
}