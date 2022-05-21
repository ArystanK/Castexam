package kz.arctan.castexam.main.presentation

import kz.arctan.castexam.main.domain.entities.Subject

data class MainUiState(
    val subjects: List<Subject> = emptyList(),
    val username: String = "",
    val name: String = "",
    val surname: String = "",

)
