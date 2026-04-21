package ru.istu.lab4mycitynavigator

data class Recommendation(
    val id: Int,
    val categoryId: Int,
    val titleResId: Int,
    val subtitleResId: Int,
    val detailsResId: Int,
    val imageResId: Int,
)
