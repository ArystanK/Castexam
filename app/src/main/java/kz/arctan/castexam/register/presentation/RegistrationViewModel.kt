package kz.arctan.castexam.register.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kz.arctan.castexam.register.domain.use_cases.RegistrationUseCase
import kz.arctan.castexam.register.domain.use_cases.ValidationUseCase
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registrationUseCase: RegistrationUseCase
) : ViewModel() {
    var uiState by mutableStateOf(RegistrationUiState())
        private set

    fun acceptIntent(registrationIntent: RegistrationIntent) {
        when (registrationIntent) {
            is RegistrationIntent.NameChange -> {
                uiState = uiState.copy(
                    name = registrationIntent.name
                )
            }
            is RegistrationIntent.PasswordChange -> {
                uiState = uiState.copy(
                    password = registrationIntent.password
                )
            }
            RegistrationIntent.Register -> {
                viewModelScope.launch {
                    registrationUseCase(
                        uiState.username,
                        uiState.password,
                        uiState.name,
                        uiState.surname
                    )
                }
            }
            is RegistrationIntent.SurnameChange -> {
                uiState = uiState.copy(
                    surname = registrationIntent.surname
                )
            }
            is RegistrationIntent.UsernameChange -> {
                uiState = uiState.copy(username = registrationIntent.username)
            }
        }
    }
}