package kz.arctan.castexam.register.data.remote

import kz.arctan.castexam.register.data.remote.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationService {
    @POST("auth/register")
    suspend fun register(@Body user: UserDto) : Response<*>
}