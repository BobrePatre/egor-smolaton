package ru.umom.hackaton.app.item.delivery

import org.hibernate.cache.spi.support.AbstractReadWriteAccess
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.umom.hackaton.app.item.dto.CreateItemRq
import ru.umom.hackaton.app.item.dto.ItemRs
import ru.umom.hackaton.app.item.usecase.ItemUsecase


@RestController
@RequestMapping("/items")
class ItemController(
    private val itemUsecase: ItemUsecase
) {

    @PostMapping
    fun create(@RequestBody item: CreateItemRq) {
        itemUsecase.create(item)
    }

    @GetMapping("/type/{type}")
    fun getByType(@PathVariable type: String): List<ItemRs> = itemUsecase.getByType(type)

    @GetMapping("/author/{author}")
    fun getByAuthor(@PathVariable author: String): List<ItemRs> = itemUsecase.getByAuthorId(author)

    @GetMapping("/{itemId}")
    fun getById(@PathVariable itemId: String): ItemRs = itemUsecase.getById(itemId)

}