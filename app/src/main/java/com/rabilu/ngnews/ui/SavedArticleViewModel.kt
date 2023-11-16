package com.rabilu.ngnews.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.domain.use_case.saved_article.DeleteSavedArticleUseCase
import com.rabilu.ngnews.domain.use_case.saved_article.GetAllSavedArticleUseCase
import com.rabilu.ngnews.domain.use_case.saved_article.GetSavedArticleUseCase
import com.rabilu.ngnews.domain.use_case.saved_article.SavedArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedArticleViewModel @Inject constructor(
    getAllSavedArticleUseCase: GetAllSavedArticleUseCase,
    private val getSavedArticleUseCase: GetSavedArticleUseCase,
    private val savedArticleUseCase: SavedArticleUseCase,
    private val deleteSavedArticleUseCase: DeleteSavedArticleUseCase
) : ViewModel() {

    val allSavedArticles = getAllSavedArticleUseCase

    var saveArticle = MutableStateFlow(Article())
    fun getSavedArticle(id: String) {
        viewModelScope.launch {
            getSavedArticleUseCase(id).collect {
                saveArticle.value = it
            }
        }
    }

    fun saveArticle(article: Article) {
        viewModelScope.launch {
            savedArticleUseCase(article)
        }
    }

    fun deleteSaveArticle(article: Article) {
        viewModelScope.launch {
            deleteSavedArticleUseCase(article)
        }
    }
}