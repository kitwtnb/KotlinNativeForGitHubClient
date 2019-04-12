package com.github.kitwtnb.kotlinnativetutorial.model.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class License(
    val key: String,
    val name: String,
    @SerialName("node_id") val nodeId: String,
    @SerialName("spdx_id") val spdxId: String,
    val url: String?
)
