package kz.arctan.castexam.login.data.remote

import kz.arctan.castexam.login.data.remote.dto.LoginResponseDto
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {
    @POST("auth/login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): LoginResponseDto
}
