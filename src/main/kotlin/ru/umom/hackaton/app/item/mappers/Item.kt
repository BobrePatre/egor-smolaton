package ru.umom.hackaton.app.item.mappers

import org.springframework.boot.configurationprocessor.metadata.ItemMetadata
import ru.umom.hackaton.app.item.dto.ItemRs
import ru.umom.hackaton.app.item.entity.ItemEntity


fun ItemEntity.toDto() = ItemRs(
    id = id,
    description = description,
    title = title,
    tags = tags,
    photoUrl = photoUrl,
    itemUrl = itemUrl,
    authorId = authorId,
    type = type,
)