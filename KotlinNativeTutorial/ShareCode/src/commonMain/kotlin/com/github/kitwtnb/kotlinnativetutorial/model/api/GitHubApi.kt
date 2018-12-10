package com.github.kitwtnb.kotlinnativetutorial.model.api

import com.github.kitwtnb.kotlinnativetutorial.model.data.Repositories

internal interface GithubApi {
    suspend fun repositories(query: String): Repositories
}

internal class GithubApiImpl(private val apiClient: ApiClient) : GithubApi {
    override suspend fun repositories(query: String): Repositories = apiClient.get("search/repositories", mapOf("q" to query))
}
