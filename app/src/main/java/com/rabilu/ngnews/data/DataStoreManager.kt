package com.rabilu.ngnews.data

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class DataStoreManager(
    private val context: Context
) {

    var firstLaunch = mutableStateOf(true)

    companion object {
        val FIRST_TIME_LAUNCH = booleanPreferencesKey("example_counter")

        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    }

    suspend fun getFetchData() {
        context.dataStore.data
            .map { preferences ->
                preferences[FIRST_TIME_LAUNCH] ?: true
            }.collect {
                firstLaunch.value = it
            }
    }

    suspend fun updateLaunchStatus() {
        context.dataStore.edit { settings ->
            settings[FIRST_TIME_LAUNCH] = false
        }
    }

}