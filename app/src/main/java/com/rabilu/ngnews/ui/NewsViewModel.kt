package com.rabilu.ngnews.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.domain.use_case.GetNewUseCase
import com.rabilu.ngnews.domain.use_case.LocalDBGetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    val getNewUseCase: GetNewUseCase,
    localDBGetNewsUseCase: LocalDBGetNewsUseCase,
) : ViewModel() {
    val newsList = localDBGetNewsUseCase()

    fun fetchNews() {
        viewModelScope.launch {
            getNewUseCase()
        }
    }


    init {
        fetchNews()
    }
}