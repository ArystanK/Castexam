package kz.arctan.castexam.main.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var mainUiState by mutableStateOf(MainUiState())
        private set

    fun acceptIntent(mainIntent: MainIntent) {
        when (mainIntent) {
            MainIntent.AddNewSubject -> {
                mainUiState = mainUiState.copy(showCreateSubjectDialog = true)
            }
            MainIntent.OpenSettings -> TODO()
            is MainIntent.OpenSubject -> TODO()
            MainIntent.DismissDialog -> {
                mainUiState = mainUiState.copy(showCreateSubjectDialog = false)
            }
            is MainIntent.NewSubjectTitleChange -> {
                mainUiState = mainUiState.copy(newSubjectTitle = mainIntent.title)
            }
            MainIntent.CreateNewSubject -> TODO()
        }
    }
}