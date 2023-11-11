package com.rabilu.ngnews.ui

import androidx.lifecycle.ViewModel
import com.rabilu.ngnews.domain.use_case.GetNewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewUseCase: GetNewUseCase) : ViewModel() {
    val newsList = getNewUseCase()

    init {

    }
}