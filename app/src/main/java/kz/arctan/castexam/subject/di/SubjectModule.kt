package kz.arctan.castexam.subject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.arctan.castexam.common.data.AuthInterceptor
import kz.arctan.castexam.common.data.Const.BASE_URL
import kz.arctan.castexam.common.data.DataStoreManager
import kz.arctan.castexam.subject.data.remote.SubjectService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SubjectModule {

    @Provides
    @Singleton
    fun provideAthInterceptor(
        dataStoreManager: DataStoreManager
    ): AuthInterceptor {
        val token = dataStoreManager.getFromDataStore()
        return AuthInterceptor(token)
    }

    @Provides
    @Singleton
    fun providesSubjectService(
        authInterceptor: AuthInterceptor
    ): SubjectService {
        return Retrofit.Builder()
            .client(
                OkHttpClient().newBuilder()
                    .addInterceptor(authInterceptor)
                    .build()
            )
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}