package com.github.kitwtnb.kotlinnativetutorial

import com.github.kitwtnb.kotlinnativetutorial.model.api.ApiClient
import com.github.kitwtnb.kotlinnativetutorial.model.api.GithubApiImpl
import com.github.kitwtnb.kotlinnativetutorial.model.data.Item
import com.github.kitwtnb.kotlinnativetutorial.model.data.License
import com.github.kitwtnb.kotlinnativetutorial.model.data.Owner
import com.github.kitwtnb.kotlinnativetutorial.model.data.Repositories
import com.github.kitwtnb.kotlinnativetutorial.model.repository.GithubRepositoryImpl
import com.github.kitwtnb.kotlinnativetutorial.presenter.SearchRepositoryPresenter
import com.github.kitwtnb.kotlinnativetutorial.presenter.SearchRepositoryPresenterImpl
import com.github.kitwtnb.kotlinnativetutorial.view.SearchRepositoryView
import io.ktor.client.features.json.serializer.KotlinxSerializer

object PresenterFactory {
    fun getSearchRepositoryPresenter(searchRepositoryView: SearchRepositoryView): SearchRepositoryPresenter {
        val apiClient = ApiClient(
            baseUrl = "https://api.github.com",
            serializer = KotlinxSerializer().also {
                it.setMapper(Repositories::class, Repositories.serializer())
                it.setMapper(Item::class, Item.serializer())
                it.setMapper(Owner::class, Owner.serializer())
                it.setMapper(License::class, License.serializer())
            }
        )
        val api = GithubApiImpl(apiClient)
        val repository = GithubRepositoryImpl(api)
        return SearchRepositoryPresenterImpl(searchRepositoryView, repository)
    }
}
