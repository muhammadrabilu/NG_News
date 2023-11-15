package com.rabilu.ngnews.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class News(
    @PrimaryKey(autoGenerate = false)
    val publishedAt: String,
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val source: String? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
)