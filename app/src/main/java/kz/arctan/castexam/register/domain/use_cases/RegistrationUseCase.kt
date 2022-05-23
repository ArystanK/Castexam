package kz.arctan.castexam.register.domain.use_cases

import kz.arctan.castexam.register.data.remote.RegistrationService
import kz.arctan.castexam.register.data.remote.dto.UserDto
import retrofit2.HttpException
import javax.inject.Inject

class RegistrationUseCase @Inject constructor(
    private val registrationService: RegistrationService
) {
    suspend operator fun invoke(
        username: String,
        password: String,
        firstname: String,
        lastname: String
    ) {
        try {
            registrationService.register(
                UserDto(
                    username = username,
                    password = password,
                    firstName = firstname,
                    lastName = lastname
                )
            )
        } catch (e: HttpException) {
            throw Exception("Unable to register")
        }
    }
}