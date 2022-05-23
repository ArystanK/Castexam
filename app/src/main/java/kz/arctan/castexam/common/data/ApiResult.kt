package kz.arctan.castexam.common.data

sealed class ApiResult<out T>(val status: ApiStatus, val data: T?, val message: String?) {
    data class Success<T>(val _data: T?) : ApiResult<T>(
        status = ApiStatus.SUCCESS,
        data = _data,
        message = null
    )

    data class Error(val exception: String) : ApiResult<Nothing>(
        status = ApiStatus.ERROR,
        data = null,
        message = exception
    )

    data class Loading<T>(val _data: T?, val isLoading: Boolean) : ApiResult<T>(
        status = ApiStatus.LOADING,
        data = _data,
        message = null
    )
}
