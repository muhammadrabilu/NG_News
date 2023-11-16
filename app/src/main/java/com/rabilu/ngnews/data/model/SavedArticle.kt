package com.rabilu.ngnews.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "saved_article")
@Parcelize
data class SavedArticle(
    @PrimaryKey(autoGenerate = false)
    val publishedAt: String,
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val source: String? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val isSaved: Boolean = false
) : Parcelable