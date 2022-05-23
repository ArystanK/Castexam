package kz.arctan.castexam.register.domain.use_cases

object ValidationUseCase {
    fun validatePassword(password: String) = PasswordValidationResult(
        hasEightCharacters = password.length >= 8,
        hasUpperCaseLetters = password.any { it.isUpperCase() },
        hasDigits = password.any { it.isDigit() },
        hasLowerCaseLetters = password.any { it.isLowerCase() }
    )

    fun validateGeneralString(string: String) = string.isNotBlank()

    data class ValidationResult(
        val isValidName: Boolean = false,
        val isValidSurname: Boolean = false,
        val isValidUsername: Boolean = false,
        val passwordValidationResult: PasswordValidationResult = PasswordValidationResult()
    )

    data class PasswordValidationResult(
        val hasEightCharacters: Boolean = false,
        val hasUpperCaseLetters: Boolean = false,
        val hasLowerCaseLetters: Boolean = false,
        val hasDigits: Boolean = false
    )
}
