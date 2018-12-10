package com.github.kitwtnb.kotlinnativetutorial.model.repository

import com.github.kitwtnb.kotlinnativetutorial.model.api.GithubApi
import com.github.kitwtnb.kotlinnativetutorial.model.data.Repositories


internal interface GithubRepository {
    suspend fun repositories(query: String): Repositories
}

internal class GithubRepositoryImpl(private val githubApi: GithubApi) : GithubRepository {
    override suspend fun repositories(query: String): Repositories = githubApi.repositories(query)
}
