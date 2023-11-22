package com.rabilu.ngnews.data

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore

class DataStoreManager(
    private val context: Context
) {

    var firstLaunch = mutableStateOf(true)

    companion object {
        val FIRST_TIME_LAUNCH = booleanPreferencesKey("example_counter")

        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    }

    suspend fun getFetchData() {
        Log.d("TAG", "getFetchData: called")
        context.dataStore.data.collect { preferences ->
            Log.d("TAG", "getFetchData: ${preferences[FIRST_TIME_LAUNCH]}")
            firstLaunch.value = preferences[FIRST_TIME_LAUNCH] ?: true
        }
//        context.dataStore.data
//            .map { preferences ->
//                Log.d("TAG", "getFetchData: ${preferences[FIRST_TIME_LAUNCH]}")
//                firstLaunch.value = preferences[FIRST_TIME_LAUNCH] ?: true
//            }
    }

    suspend fun updateLaunchStatus() {
        context.dataStore.edit { settings ->
            settings[FIRST_TIME_LAUNCH] = false
        }
    }

}