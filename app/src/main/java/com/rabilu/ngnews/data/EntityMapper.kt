package com.rabilu.ngnews.data

import com.rabilu.ngnews.data.model.News
import com.rabilu.ngnews.domain.model.Article

interface EntityMapper<EntityDTO, DomainModel> {
    fun mapFromEntity(entityDTO: EntityDTO): DomainModel
    fun mapFromDomain(domainModel: DomainModel): EntityDTO

    fun listMapFromEntity(entityDTO: List<EntityDTO>): List<Article>
    fun listMapFromDomain(domainModel: List<DomainModel>): List<News>
}