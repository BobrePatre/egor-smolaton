package ru.umom.hackaton.app.item.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.umom.hackaton.app.item.entity.ItemEntity


@Repository
interface ItemRepository : JpaRepository<ItemEntity, String> {
    fun findAllByAuthorId(authorId: String): List<ItemEntity>
    fun findAllByType(typeId: String): List<ItemEntity>
}