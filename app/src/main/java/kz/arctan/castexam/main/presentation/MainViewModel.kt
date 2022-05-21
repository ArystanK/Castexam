package kz.arctan.castexam.main.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var mainUiState by mutableStateOf(MainUiState())
        private set

    fun acceptIntent(mainIntent: MainIntent) {

    }
}