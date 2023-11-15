package com.rabilu.ngnews.data.model

import com.rabilu.ngnews.data.EntityMapper
import com.rabilu.ngnews.domain.model.Article
import com.rabilu.ngnews.domain.model.Source

class NewsMapper : EntityMapper<News, Article> {
    override fun mapFromEntity(entityDTO: News): Article = Article(
        author = entityDTO.author.toString(),
        content = entityDTO.content,
        title = entityDTO.title,
        url = entityDTO.url,
        description = entityDTO.description,
        publishedAt = entityDTO.publishedAt,
        source = Source(null, entityDTO.source!!),
        urlToImage = entityDTO.urlToImage.toString()
    )

    override fun mapFromDomain(domainModel: Article): News = News(
        author = domainModel.author,
        content = domainModel.content.toString(),
        publishedAt = domainModel.publishedAt.toString(),
        title = domainModel.title.toString(),
        description = domainModel.description.toString(),
        source = domainModel.source!!.name,
        urlToImage = domainModel.urlToImage,
        url = domainModel.url.toString()
    )

    override fun listMapFromEntity(entityDTO: List<News>): List<Article> {
        return entityDTO.map { mapFromEntity(it) }
    }

    override fun listMapFromDomain(domainModel: List<Article>): List<News> {
        return domainModel.map { mapFromDomain(it) }
    }


}