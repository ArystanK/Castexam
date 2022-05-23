package kz.arctan.castexam.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.arctan.castexam.common.data.DataStoreManager
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object CommonModule {
//    @Provides
//    @Singleton
//    fun provideDataStore() = DataStoreManager()
//}