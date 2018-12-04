package com.github.kitwtnb.kotlinnativetutorial.model.data

import kotlinx.serialization.Serializable

@Serializable
data class Repositories(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<Item>
)
