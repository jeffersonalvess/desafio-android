package com.picpay.desafio.android.recycler.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class UserAdapterViewHolder(
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root)
