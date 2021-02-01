package com.hilt.demo.model

import androidx.recyclerview.widget.DiffUtil

class DiffUtilPostsModelItems : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(
        oldItem: Data,
        newItem: Data
    ): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(
        oldItem: Data,
        newItem: Data
    ): Boolean {
        return newItem == oldItem
    }
}