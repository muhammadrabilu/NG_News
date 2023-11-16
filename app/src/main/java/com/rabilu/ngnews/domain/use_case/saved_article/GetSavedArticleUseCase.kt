package com.rabilu.ngnews.domain.use_case.saved_article

import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.domain.repository.SavedArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedArticleUseCase @Inject constructor(private val saveArtRepository: SavedArticleRepository) {
    suspend operator fun invoke(id: String): Flow<Article> {
        return saveArtRepository.getSavedArticle(id)
    }
}