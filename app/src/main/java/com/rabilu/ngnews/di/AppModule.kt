package com.rabilu.ngnews.di

import android.app.Application
import com.rabilu.ngnews.data.DataStoreManager
import com.rabilu.ngnews.data.respository.NewsRepositoryImp
import com.rabilu.ngnews.domain.repository.NewsRepository
import com.rabilu.ngnews.network.api.NGnewService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideDataStoreManger(applicationContext: Application) =
        DataStoreManager(applicationContext)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideNewsApis(retrofit: Retrofit): NGnewService =
        retrofit.create(NGnewService::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(nGnewService: NGnewService): NewsRepository =
        NewsRepositoryImp(nGnewService)
}