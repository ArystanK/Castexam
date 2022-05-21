package kz.arctan.castexam.login.presentation

interface LoginIntent {
    data class UsernameChange(val username: String) : LoginIntent
    data class PasswordChange(val password: String) : LoginIntent
    object Login : LoginIntent
}