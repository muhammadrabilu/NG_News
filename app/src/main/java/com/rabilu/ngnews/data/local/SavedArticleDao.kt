package com.rabilu.ngnews.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rabilu.ngnews.data.model.SavedArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedArticleDao {

    @Query("SELECT * FROM saved_article")
    fun getAllSavedArticles(): Flow<List<SavedArticle>>

    @Query("SELECT * FROM saved_article WHERE publishedAt = :id ")
    fun getSavedArticles(id: String): Flow<SavedArticle>?

    @Delete
    suspend fun delete(savedArticle: SavedArticle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArticle(news: SavedArticle)

}