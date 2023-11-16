package com.rabilu.ngnews.data.respository

import android.util.Log
import com.rabilu.ngnews.data.local.NGNewsDB
import com.rabilu.ngnews.data.util.SavedArticleMapper
import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.domain.repository.SavedArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SavedArticleImpl @Inject constructor(db: NGNewsDB) : SavedArticleRepository {

    private val savedArticleDao = db.savedArticleDao()
    private val mapper = SavedArticleMapper()
    private var savedArticle = MutableStateFlow(Article())
    override fun getAllSavedArticle(): Flow<List<Article>> = flow {
        emit(mapper.listMapFromEntity(savedArticleDao.getAllSavedArticles().first()))
    }

    override suspend fun getSavedArticle(id: String): MutableStateFlow<Article> {
        val da = savedArticleDao.getSavedArticles(id)?.first()
        if (da != null) {
            savedArticle.value = mapper.mapFromEntity(da)
        } else {
            savedArticle.value = Article()
        }
        return savedArticle
    }

    override suspend fun saveArticle(article: Article) {
        savedArticleDao.saveArticle(SavedArticleMapper().mapFromDomain(article))
    }

    override suspend fun deleteSaveArticle(article: Article) {
        savedArticleDao.delete(SavedArticleMapper().mapFromDomain(article))
    }
}