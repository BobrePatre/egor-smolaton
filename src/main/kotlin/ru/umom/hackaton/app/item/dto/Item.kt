package ru.umom.hackaton.app.item.dto


class CreateItemRq(
    val authorId: String,
    val title: String,
    val description: String,
    val itemUrl: String,
    val photoUrl: String,
    val type: String,
    val tags: List<String>
)

class ItemRs(
    val id: String,
    val authorId: String,
    val title: String,
    val description: String,
    val itemUrl: String,
    val photoUrl: String,
    val tags: List<String>,
    val type: String,
)