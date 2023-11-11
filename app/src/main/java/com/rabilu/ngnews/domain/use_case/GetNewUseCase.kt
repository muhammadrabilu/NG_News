package com.rabilu.ngnews.domain.use_case

import com.rabilu.ngnews.domain.model.NewsResponse
import com.rabilu.ngnews.domain.repository.NewsRepository
import com.rabilu.ngnews.network.api.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    operator fun invoke(query: String? = null): Flow<Resource<NewsResponse>> {
        return if (query != null) {
            newsRepository.getAllNews(query)
        } else {
            newsRepository.getAllNews()
        }
    }
}