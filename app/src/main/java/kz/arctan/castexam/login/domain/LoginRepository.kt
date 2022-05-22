package kz.arctan.castexam.login.domain

interface LoginRepository {
    suspend fun login(username: String, password: String)
}