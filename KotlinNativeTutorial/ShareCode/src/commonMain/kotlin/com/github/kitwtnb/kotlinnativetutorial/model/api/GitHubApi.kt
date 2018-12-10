package com.github.kitwtnb.kotlinnativetutorial.model.api

import com.github.kitwtnb.kotlinnativetutorial.model.data.Repositories

internal interface GithubApi {
    suspend fun repositories(query: String? = null): Repositories
}

internal class GithubApiImpl(private val apiClient: ApiClient) : GithubApi {
    override suspend fun repositories(query: String?): Repositories {
        val param = if (query == null) {
            null
        } else {
            mapOf("q" to query)
        }
        return apiClient.get("search/repositories", param)
    }
}
