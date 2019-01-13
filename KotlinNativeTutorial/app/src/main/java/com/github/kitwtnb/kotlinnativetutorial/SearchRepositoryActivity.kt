package com.github.kitwtnb.kotlinnativetutorial

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.widget.Toast
import com.github.kitwtnb.kotlinnativetutorial.model.data.Item
import com.github.kitwtnb.kotlinnativetutorial.presenter.SearchRepositoryPresenter
import com.github.kitwtnb.kotlinnativetutorial.view.SearchRepositoryView
import kotlinx.android.synthetic.main.activity_search_repository.*

class SearchRepositoryActivity : AppCompatActivity(), SearchRepositoryView {

    private lateinit var presenter: SearchRepositoryPresenter
    private lateinit var adapter: SearchRepositoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_repository)

        presenter = PresenterFactory.getSearchRepositoryPresenter(this)
        adapter = SearchRepositoryAdapter()

        recycler_view.layoutManager = LinearLayoutManager(this@SearchRepositoryActivity)
        recycler_view.addItemDecoration(
            DividerItemDecoration(
                this@SearchRepositoryActivity,
                DividerItemDecoration.VERTICAL
            )
        )
        recycler_view.adapter = this@SearchRepositoryActivity.adapter

        search_repository.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(searchText: String): Boolean {
                presenter.search(searchText)
                search_repository.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showRepositories(repositories: List<Item>) {
        adapter.submitList(repositories)
    }
}
