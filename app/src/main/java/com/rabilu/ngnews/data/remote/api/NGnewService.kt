package com.rabilu.ngnews.data.remote.api

import com.rabilu.ngnews.domain.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NGnewService {

    @GET("/v2/everything")
    @Headers("x-api-key: a85ddf559b66420eafe11ebd9383b25e")
    suspend fun getAllNews(@Query("q") query: String = "politics"): Response<NewsResponse>
}