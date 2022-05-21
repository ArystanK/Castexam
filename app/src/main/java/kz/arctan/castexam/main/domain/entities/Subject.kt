package kz.arctan.castexam.main.domain.entities

data class Subject(
    val id: Int,
    val title: String,
    val numberOfTests: Int,
    val numberOfQuestions: Int
)
