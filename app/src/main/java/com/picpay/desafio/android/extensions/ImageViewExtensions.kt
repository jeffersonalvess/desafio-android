package com.picpay.desafio.android.extensions

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.picpay.desafio.android.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_user.view.*

fun ImageView.loadFromUrl(url: String, @DrawableRes defaultImage: Int) {
    Picasso.get()
        .load(url)
        .error(defaultImage)
        .into(this, object : Callback {
            override fun onSuccess() {
               // Do nothing
            }

            override fun onError(e: Exception?) {
                // Do nothing
            }
        })
}