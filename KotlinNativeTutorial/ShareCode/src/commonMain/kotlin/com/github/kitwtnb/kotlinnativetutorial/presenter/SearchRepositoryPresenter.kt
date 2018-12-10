package com.github.kitwtnb.kotlinnativetutorial.presenter

import com.github.kitwtnb.kotlinnativetutorial.model.repository.GithubRepository
import com.github.kitwtnb.kotlinnativetutorial.view.SearchRepositoryView
import kotlinx.coroutines.launch

interface SearchRepositoryPresenter : Presenter {
    fun search(query: String)
}

internal class SearchRepositoryPresenterImpl(
    private val view: SearchRepositoryView,
    private val repository: GithubRepository
) : CoroutinePresenter(), SearchRepositoryPresenter {
    override fun search(query: String) {
        launch (coroutineContext) {
            try {
                val repositories = repository.repositories(query)
                view.showRepositories(repositories.items)
            } catch (t: Throwable) {
                view.showError(t.toString())
            }
        }
    }
}
