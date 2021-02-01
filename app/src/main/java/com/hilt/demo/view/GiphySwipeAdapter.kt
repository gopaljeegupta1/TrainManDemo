package com.hilt.demo.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hilt.demo.R
import com.hilt.demo.model.Data
import com.hilt.demo.model.DiffUtilPostsModelItems
import kotlinx.android.synthetic.main.item_layout.view.*

class GiphySwipeAdapter : ListAdapter<Data, GiphySwipeAdapter.PostViewHolder>(
    DiffUtilPostsModelItems()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false
        )
    )

    override fun onBindViewHolder(holder: GiphySwipeAdapter.PostViewHolder, position: Int) =
        holder.bind(getItem(position))


    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val layout = view.post_layout
        private val title = view.tv_title
        private val image = view.iv_image
        fun bind(model: Data) {
            Log.d("PostSwipeAdapter", "In bind() method.......")
            title.text = model.title
            Glide.with(itemView.context)
                .load(model.images.original.url)
                .placeholder(R.drawable.loading_image)
                .into(image)

            layout.setOnClickListener {

                val bundlee = Bundle()
                bundlee.putString("id", model.id)
                bundlee.putString("title", model.title)
                bundlee.putString("username", model.username)
                bundlee.putString("rating", model.rating)
                bundlee.putString("url", model.url)
                bundlee.putString("imgUrl", model.images.downsized_large.url)
                val intents = Intent(itemView.context, DetailsActivity::class.java)
                intents.putExtras(bundlee)
                ContextCompat.startActivity(itemView.context, intents, null)

            }

        }

    }

}