package kz.arctan.castexam.common.domain.entities

data class Question(
    val id: Int = 0,
    val title: String = "",
    val answers: List<Answer> = emptyList()
)
