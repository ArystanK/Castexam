package kz.arctan.castexam.login.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kz.arctan.castexam.common.data.ApiResult
import kz.arctan.castexam.common.data.DataStoreManager
import kz.arctan.castexam.login.data.remote.LoginService
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginService: LoginService,
    private val dataStoreManager: DataStoreManager
) {
    operator fun invoke(
        username: String,
        password: String
    ): Flow<ApiResult<Nothing>> = flow {
        emit(ApiResult.Loading(_data = null, isLoading = true))
        try {
            val result = loginService.login(username, password)
            dataStoreManager.saveTokenToDataStore(result.token)
            emit(ApiResult.Success(_data = null))
        } catch (e: Exception) {
            emit(ApiResult.Error(exception = e.localizedMessage ?: "Some network error"))
        }
    }
}