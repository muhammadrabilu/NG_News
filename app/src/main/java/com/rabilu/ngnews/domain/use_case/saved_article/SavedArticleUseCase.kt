package com.rabilu.ngnews.domain.use_case.saved_article

import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.domain.repository.SavedArticleRepository
import javax.inject.Inject

class SavedArticleUseCase @Inject constructor(private val savedArticleRepository: SavedArticleRepository) {
    suspend operator fun invoke(article: Article) = savedArticleRepository.saveArticle(article)
}