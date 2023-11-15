package com.rabilu.ngnews.data.respository

import android.util.Log
import androidx.room.withTransaction
import com.rabilu.ngnews.data.local.NGNewsDB
import com.rabilu.ngnews.data.model.NewsMapper
import com.rabilu.ngnews.data.remote.api.NGnewService
import com.rabilu.ngnews.data.remote.api.Resource
import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class NewsRepositoryImp @Inject constructor(
    private val nGnewService: NGnewService, val localDB: NGNewsDB
) : NewsRepository {

    val newsDao = localDB.newsDao()
    private val newsState = MutableStateFlow<Resource<List<Article>>>(Resource.Loading())

    override suspend fun networkGetAllNews(query: String?) {
        newsState.value = Resource.Loading(
            data = NewsMapper().listMapFromEntity(
                newsDao.getAllNews().first()
            )
        )
        try {
            val resopons =
                if (query != null) nGnewService.getAllNews(query) else nGnewService.getAllNews()
            if (resopons.isSuccessful && resopons.body() != null) {
                localDB.withTransaction {
                    newsDao.deleteAll()
                    newsDao.saveAll(NewsMapper().listMapFromDomain(resopons.body()!!.articles))
                }
                newsState.value = Resource.Success(
                    data = NewsMapper().listMapFromEntity(
                        newsDao.getAllNews().first()
                    )
                )
            }

        } catch (e: Exception) {
            Log.e("TAG", "getAllNews: ${e.localizedMessage}")
            newsState.value = Resource.Error(
                data = NewsMapper().listMapFromEntity(
                    newsDao.getAllNews().first()
                ), errorMessage = e.localizedMessage
            )

        }
    }

    override fun getAllNews(): Flow<Resource<List<Article>>> = newsState

}