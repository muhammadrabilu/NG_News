package com.rabilu.ngnews.data.respository

import android.util.Log
import com.rabilu.ngnews.domain.model.NewsResponse
import com.rabilu.ngnews.domain.repository.NewsRepository
import com.rabilu.ngnews.network.api.NGnewService
import com.rabilu.ngnews.network.api.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImp @Inject constructor(private val nGnewService: NGnewService) :
    NewsRepository {
    override fun getAllNews(query: String?): Flow<Resource<NewsResponse>> = flow {
        try {
            emit(Resource.Loading())
            val resopons =
                if (query != null) nGnewService.getAllNews(query) else nGnewService.getAllNews()
            if (resopons.isSuccessful) {
                emit(Resource.Success(resopons.body()))
            }
            Log.d("TAG", "getAllNews: ${resopons.errorBody()}")
        } catch (e: Exception) {
            Log.d("TAG", "getAllNews: ${e.localizedMessage}")
            emit(Resource.Error(errorMessage = e.localizedMessage))
        }

    }

}