package kz.arctan.castexam.login.data.remote

import kz.arctan.castexam.login.domain.LoginRepository
import kz.arctan.castexam.login.domain.UnableToLoginException
import retrofit2.HttpException
import javax.inject.Inject

class LoginRepositoryImplementation @Inject constructor(
    private val loginService: LoginService
) : LoginRepository {
    override suspend fun login(username: String, password: String) {
        try {
            val response = loginService.login(username, password)
            //TODO(save token from response to data store
        } catch (e: HttpException) {
            throw UnableToLoginException()
        }
    }
}