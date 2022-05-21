package kz.arctan.castexam.register.presentation

import kz.arctan.castexam.register.domain.use_cases.ValidationUseCase

data class RegistrationUiState(
    val name: String = "",
    val surname: String = "",
    val username: String = "",
    val password: String = "",
    val validationResult: ValidationUseCase.ValidationResult = ValidationUseCase.ValidationResult()
)