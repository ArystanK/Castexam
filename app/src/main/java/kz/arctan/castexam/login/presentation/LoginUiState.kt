package kz.arctan.castexam.login.presentation

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val loginState: Boolean? = null,
    val isLoading: Boolean = false
)
