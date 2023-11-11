package com.rabilu.ngnews.domain.repository

import com.rabilu.ngnews.domain.model.NewsResponse
import com.rabilu.ngnews.network.api.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getAllNews(query: String? = null): Flow<Resource<NewsResponse>>
}