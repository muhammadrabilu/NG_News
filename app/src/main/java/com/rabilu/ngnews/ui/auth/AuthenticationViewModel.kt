package com.rabilu.ngnews.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabilu.ngnews.data.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(dataStoreManager: DataStoreManager) :
    ViewModel() {
    val launch = dataStoreManager.firstLaunch

    init {
        viewModelScope.launch {
            dataStoreManager.getFetchData()
        }
    }

}