package com.rabilu.ngnews.domain.repository

import com.rabilu.ngnews.data.remote.api.Resource
import com.rabilu.ngnews.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun networkGetAllNews(query: String? = null)
    fun getAllNews(): Flow<Resource<List<Article>>>

    suspend fun saveArticle(article: Article)
}