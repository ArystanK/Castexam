package kz.arctan.castexam.common.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kz.arctan.castexam.common.data.Const.DATA_STORE_NAME
import javax.inject.Inject

class DataStoreManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATA_STORE_NAME)

    companion object {
        val TOKEN = stringPreferencesKey("TOKEN")

        /*
            -1 - dark mode
            0 - system default
            1 - light mode
         */
        val MODE = intPreferencesKey("MODE")
    }

    suspend fun saveTokenToDataStore(token: String) {
        context.dataStore.edit {
            it[TOKEN] = token
        }
    }

    suspend fun saveModeToDataStore(mode: Int) {
        context.dataStore.edit {
            it[MODE] = mode
        }
    }

    fun getModeFromDataStore(): Int {
        var result = 0
        runBlocking {
            context.dataStore.data.collect {
                result = it[MODE] ?: 0
            }
        }
        return result
    }

    fun getTokenFromDataStore(): String {
        var result: String? = null
        runBlocking {
            context.dataStore.data.collect {
                result = it[TOKEN]
            }
        }
        return result ?: ""
    }
}
