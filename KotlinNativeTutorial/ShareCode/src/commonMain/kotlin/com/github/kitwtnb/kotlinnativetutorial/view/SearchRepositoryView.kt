package com.github.kitwtnb.kotlinnativetutorial.view

import com.github.kitwtnb.kotlinnativetutorial.model.data.Item

interface SearchRepositoryView {
    fun showRepositories(repositories: List<Item>)
    fun showError(message: String)
}
