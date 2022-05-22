package kz.arctan.castexam.common.data

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(
            request.newBuilder()
                .header("Authorization", "Bearer $token")
                .method(request.method(), request.body())
                .build()
        )
    }
}