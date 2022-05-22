package kz.arctan.castexam.login.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginResponseDto(
    val httpStatus: Int,
    val errorMessage: String?,
    @SerializedName("data") val token: String,
    val success: Boolean
)