package com.picpay.desafio.android.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.picpay.desafio.android.R
import com.picpay.desafio.android.extensions.loadFromUrl
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

@BindingAdapter("userImage")
fun ImageView.src(url: String) {
    loadFromUrl(url, R.drawable.ic_round_account_circle)
}
