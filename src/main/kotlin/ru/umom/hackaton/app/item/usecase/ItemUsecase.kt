package ru.umom.hackaton.app.item.usecase

import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.umom.hackaton.app.item.dto.CreateItemRq
import ru.umom.hackaton.app.item.dto.ItemRs
import ru.umom.hackaton.app.item.entity.ItemEntity
import ru.umom.hackaton.app.item.mappers.toDto
import ru.umom.hackaton.app.item.repository.ItemRepository
import ru.umom.hackaton.shared.errors.common.NotFoundError

@Service
class ItemUsecase(
    private val itemRepository: ItemRepository
) {

    @Transactional
    fun create(dto: CreateItemRq) {
        itemRepository.save(
            ItemEntity(
                authorId = dto.authorId,
                title = dto.title,
                description = dto.description,
                tags = dto.tags,
                itemUrl = dto.itemUrl,
                photoUrl = dto.photoUrl,
                type = dto.type,
            )
        )
    }

    @Transactional
    fun getById(itemId: String): ItemRs =
        itemRepository.findByIdOrNull(itemId)?.toDto() ?: throw NotFoundError("Item not found with id: $itemId")

    @Transactional
    fun getByType(type: String): List<ItemRs> = itemRepository.findAllByType(type).map { it.toDto() }

    @Transactional
    fun getByAuthorId(authorId: String): List<ItemRs> = itemRepository.findAllByAuthorId(authorId).map { it.toDto() }


}