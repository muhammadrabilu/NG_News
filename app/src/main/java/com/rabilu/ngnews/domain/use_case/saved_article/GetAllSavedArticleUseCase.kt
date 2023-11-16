package com.rabilu.ngnews.domain.use_case.saved_article

import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.domain.repository.SavedArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllSavedArticleUseCase @Inject constructor(private val saveArtRepository: SavedArticleRepository) {
    operator fun invoke(): Flow<List<Article>> = saveArtRepository.getAllSavedArticle()
}