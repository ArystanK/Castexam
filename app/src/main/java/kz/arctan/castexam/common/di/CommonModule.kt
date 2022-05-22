package kz.arctan.castexam.common.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kz.arctan.castexam.common.data.DataStoreManager
import java.util.prefs.Preferences

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {
    @Provides
    fun provideDataStore(
        @ApplicationContext context: Application
    ) : DataStoreManager {
        return DataStoreManager(context)
    }
}