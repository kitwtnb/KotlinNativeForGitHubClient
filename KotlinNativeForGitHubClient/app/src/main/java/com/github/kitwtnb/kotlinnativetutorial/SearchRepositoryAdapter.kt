package com.github.kitwtnb.kotlinnativetutorial

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.github.kitwtnb.kotlinnativetutorial.model.data.Item
import kotlinx.android.synthetic.main.item_search_repository.view.*

class SearchRepositoryAdapter : RecyclerView.Adapter<SearchRepositoryAdapter.ItemViewHolder>() {

    private val items = mutableListOf<Item>()

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(container.context).inflate(R.layout.item_search_repository, container, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.view.text_title.text = item.name
        holder.view.text_user_name.text = item.owner.login
        holder.view.text_star_count.text = item.stargazersCount.toString()
        holder.view.text_fork_count.text = item.forksCount.toString()
        Glide.with(holder.view).load(item.owner.avatarUrl).into(holder.view.image_thumbnail)
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<Item>) {
        this.items.clear()
        this.items.addAll(items)
    }

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}