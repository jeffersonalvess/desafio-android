package com.picpay.desafio.android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.databinding.ListItemTitleBinding
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.database.entities.User

class UserListAdapter : RecyclerView.Adapter<UserAdapterViewHolder>() {

    var users = emptyList<User>()
        set(value) {
            val result = DiffUtil.calculateDiff(UserListDiffCallback(field, value))
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun getItemViewType(position: Int) =
        when (position) {
            0 -> VIEW_TYPE_HEADER
            else -> VIEW_TYPE_ITEM
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemUserBinding = ListItemUserBinding.inflate(layoutInflater, parent, false)
        val itemTitleBinding = ListItemTitleBinding.inflate(layoutInflater, parent, false)

       return when(viewType) {
            VIEW_TYPE_HEADER -> HeaderListViewHolder(itemTitleBinding)
            VIEW_TYPE_ITEM -> UserListViewHolder(itemUserBinding)
            else -> error("Unknown viewType=$viewType")
        }
    }

    override fun onBindViewHolder(holder: UserAdapterViewHolder, position: Int) {
        if(getItemViewType(position) == VIEW_TYPE_ITEM) {
            (holder as? UserListViewHolder)?.bind(users[position - 1])
        }
    }

    override fun getItemCount() = users.size + 1

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_ITEM = 1
    }
}