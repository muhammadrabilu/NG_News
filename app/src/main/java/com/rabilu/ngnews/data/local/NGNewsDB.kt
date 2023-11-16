package com.rabilu.ngnews.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rabilu.ngnews.data.model.News
import com.rabilu.ngnews.data.model.SavedArticle

@Database(entities = [News::class, SavedArticle::class], version = 5)
abstract class NGNewsDB : RoomDatabase() {
    abstract fun newsDao(): NewsDao
    abstract fun savedArticleDao(): SavedArticleDao
}