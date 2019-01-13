package com.github.kitwtnb.kotlinnativetutorial

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.github.kitwtnb.kotlinnativetutorial.model.data.Item
import kotlinx.android.synthetic.main.item_search_repository.view.*

class SearchRepositoryAdapter : ListAdapter<Item, ItemViewHolder>(ItemDiff) {
    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(container.context).inflate(R.layout.item_search_repository, container, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.view) {
            text_title.text = item.name
            text_user_name.text = item.owner.login
            text_star_count.text = item.stargazersCount.toString()
            text_fork_count.text = item.forksCount.toString()
            Glide.with(this).load(item.owner.avatarUrl).into(image_thumbnail)
        }
    }
}

class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view)

object ItemDiff : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = newItem == oldItem
}