package com.rabilu.ngnews.di

import android.app.Application
import com.rabilu.ngnews.data.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideDataStoreManger(applicationContext: Application) =
        DataStoreManager(applicationContext)


}