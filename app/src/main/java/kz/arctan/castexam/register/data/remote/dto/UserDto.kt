package kz.arctan.castexam.register.data.remote.dto

data class UserDto(
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String
)