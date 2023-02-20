package com.plcoding.cleanarchitecturenoteapp.feature_quiz.presentation.quiz

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun QuizScreen(
    modifier: Modifier,
    viewModel: QuizViewModel = hiltViewModel(),
){
    LazyColumn(modifier = Modifier.fillMaxSize()){
//        items(viewModel.state.value){note->
//            NoteItem(
//                note = note,
//                modifier = Modifier.fillMaxWidth()
//                    .clickable {
//                        navController.navigate(Screen.AddEditNoteScreen.route + "?noteId=${note.id}&noteColor=${note.color}")
//                    },
//                onDelete = {
//                    viewModel.onEvent(NotesEvent.Delete(note=note))
//                    scope.launch {
//                        var result = scaffoldState.snackbarHostState.showSnackbar(message = "Note deleted", actionLabel = "Undo")
//                        if(result == SnackbarResult.ActionPerformed){
//                            viewModel.onEvent(NotesEvent.RestoreNote)
//                        }
//                    }
//                }
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//        }
}