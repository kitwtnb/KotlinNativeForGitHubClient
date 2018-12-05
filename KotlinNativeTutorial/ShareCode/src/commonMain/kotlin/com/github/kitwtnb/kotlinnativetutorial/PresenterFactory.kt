package com.github.kitwtnb.kotlinnativetutorial

import com.github.kitwtnb.kotlinnativetutorial.model.api.ApiClient
import com.github.kitwtnb.kotlinnativetutorial.model.api.GithubApiImpl
import com.github.kitwtnb.kotlinnativetutorial.model.repository.GithubRepositoryImpl
import com.github.kitwtnb.kotlinnativetutorial.presenter.SearchRepositoryPresenter
import com.github.kitwtnb.kotlinnativetutorial.presenter.SearchRepositoryPresenterImpl
import com.github.kitwtnb.kotlinnativetutorial.view.SearchRepositoryView

object PresenterFactory {
    fun getSearchRepositoryPresenter(searchRepositoryView: SearchRepositoryView): SearchRepositoryPresenter {
        val apiClient = ApiClient(baseUrl = "https://api.github.com")
        val api = GithubApiImpl(apiClient)
        val repository = GithubRepositoryImpl(api)
        return SearchRepositoryPresenterImpl(searchRepositoryView, repository)
    }
}
