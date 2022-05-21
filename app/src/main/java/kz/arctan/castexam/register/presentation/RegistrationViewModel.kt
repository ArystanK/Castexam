package kz.arctan.castexam.register.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kz.arctan.castexam.register.domain.use_cases.RegistrationUseCase
import kz.arctan.castexam.register.domain.use_cases.ValidationUseCase

class RegistrationViewModel(
    private val validationUseCase: ValidationUseCase = ValidationUseCase(),
//    private val registrationUseCase: RegistrationUseCase
) : ViewModel() {
    var uiState by mutableStateOf(RegistrationUiState())
        private set

    fun acceptIntent(registrationIntent: RegistrationIntent) {
        when (registrationIntent) {
            RegistrationIntent.GoBack -> {
                //TODO
            }
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
                uiState = uiState.copy(
                    validationResult = validationUseCase.validate(
                        username = uiState.username,
                        password = uiState.password,
                        surname = uiState.surname,
                        name = uiState.name
                    )
                )
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