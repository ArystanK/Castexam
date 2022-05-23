package kz.arctan.castexam.login.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kz.arctan.castexam.common.data.ApiResult
import kz.arctan.castexam.login.domain.LoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
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
            LoginIntent.Login -> {
                viewModelScope.launch {
                    loginUseCase(
                        loginUiState.username,
                        loginUiState.password
                    ).collect {
                        loginUiState = when (it) {
                            is ApiResult.Error -> loginUiState.copy(loginState = false)
                            is ApiResult.Loading -> loginUiState.copy(isLoading = true)
                            is ApiResult.Success -> loginUiState.copy(loginState = true)
                        }
                    }
                }
            }
        }
    }
}