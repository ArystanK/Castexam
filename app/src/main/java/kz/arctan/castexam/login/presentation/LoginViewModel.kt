package kz.arctan.castexam.login.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var loginUiState by mutableStateOf(LoginUiState())
        private set

    fun acceptIntent(loginIntent: LoginIntent) {
        when (loginIntent) {
            is LoginIntent.PasswordChange -> {
                loginUiState = loginUiState.copy(password = loginIntent.password)
            }
            is LoginIntent.UsernameChange -> {
                loginUiState = loginUiState.copy(username = loginIntent.username)
            }
            LoginIntent.Login -> {}
        }
    }
}