package ru.umom.hackaton.app.item.entity

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "items")
class ItemEntity(
    val title: String,
    val description: String,
    val authorId: String,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item_tags", joinColumns = [JoinColumn(name = "item_id")])
    val tags: List<String>,
    val type: String,
    val itemUrl: String,
    val photoUrl: String,
) {
    @Id
    var id: String = UUID.randomUUID().toString()
}