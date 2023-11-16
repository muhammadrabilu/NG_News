package com.rabilu.ngnews.domain.repository

import com.rabilu.ngnews.domain.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface SavedArticleRepository {
    fun getAllSavedArticle(): Flow<List<Article>>
    suspend fun getSavedArticle(id: String): MutableStateFlow<Article>
    suspend fun saveArticle(article: Article)
    suspend fun deleteSaveArticle(article: Article)

}