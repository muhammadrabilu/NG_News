package com.rabilu.ngnews.data.util

interface EntityMapper<EntityDTO, DomainModel> {
    fun mapFromEntity(entityDTO: EntityDTO): DomainModel
    fun mapFromDomain(domainModel: DomainModel): EntityDTO

    fun listMapFromEntity(entityDTO: List<EntityDTO>): List<DomainModel>
    fun listMapFromDomain(domainModel: List<DomainModel>): List<EntityDTO>
}