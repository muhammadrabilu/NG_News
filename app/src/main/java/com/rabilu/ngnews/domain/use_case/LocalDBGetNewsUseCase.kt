package com.rabilu.ngnews.domain.use_case

import com.rabilu.ngnews.domain.repository.NewsRepository
import javax.inject.Inject

class LocalDBGetNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    operator fun invoke() = newsRepository.getAllNews()
}