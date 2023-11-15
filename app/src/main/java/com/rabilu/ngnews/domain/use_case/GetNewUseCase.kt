package com.rabilu.ngnews.domain.use_case

import com.rabilu.ngnews.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(query: String? = null): Any {
        return if (query != null) {
            newsRepository.networkGetAllNews(query)
        } else {
            newsRepository.networkGetAllNews()
        }
    }
}