package kz.arctan.castexam.register.presentation

sealed interface RegistrationIntent {
    data class NameChange(val name: String) : RegistrationIntent
    data class SurnameChange(val surname: String) : RegistrationIntent
    data class UsernameChange(val username: String) : RegistrationIntent
    data class PasswordChange(val password: String) : RegistrationIntent
    object Register : RegistrationIntent
}
