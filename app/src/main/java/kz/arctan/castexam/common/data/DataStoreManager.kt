package kz.arctan.castexam.common.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kz.arctan.castexam.common.data.Const.DATA_STORE_NAME

class DataStoreManager(private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATA_STORE_NAME)

    companion object {
        val TOKEN = stringPreferencesKey("TOKEN")
    }


    suspend fun saveToDataStore(token: String) {
        context.dataStore.edit {
            it[TOKEN] = token
        }
    }

    fun getFromDataStore(): String {
        var result: String? = null
        runBlocking {
            context.dataStore.data.collect {
                result = it[TOKEN]
            }
        }
        return result ?: ""
    }
}
