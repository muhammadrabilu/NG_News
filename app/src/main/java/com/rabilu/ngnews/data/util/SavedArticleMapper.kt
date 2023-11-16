package com.rabilu.ngnews.data.util

import com.rabilu.ngnews.data.model.SavedArticle
import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.domain.model.Source

class SavedArticleMapper : EntityMapper<SavedArticle, Article> {
    override fun mapFromEntity(entityDTO: SavedArticle): Article = Article(
        author = entityDTO.author.toString(),
        content = entityDTO.content,
        title = entityDTO.title,
        url = entityDTO.url,
        description = entityDTO.description,
        publishedAt = entityDTO.publishedAt,
        source = Source(null, entityDTO.source!!),
        urlToImage = entityDTO.urlToImage.toString(),
        isSaved = entityDTO.isSaved
    )

    override fun mapFromDomain(domainModel: Article): SavedArticle = SavedArticle(
        author = domainModel.author,
        content = domainModel.content.toString(),
        publishedAt = domainModel.publishedAt.toString(),
        title = domainModel.title.toString(),
        description = domainModel.description.toString(),
        source = domainModel.source!!.name,
        urlToImage = domainModel.urlToImage,
        url = domainModel.url.toString(),
        isSaved = domainModel.isSaved
    )

    override fun listMapFromEntity(entityDTO: List<SavedArticle>): List<Article> {
        return entityDTO.map { mapFromEntity(it) }
    }

    override fun listMapFromDomain(domainModel: List<Article>): List<SavedArticle> {
        return domainModel.map { mapFromDomain(it) }
    }


}