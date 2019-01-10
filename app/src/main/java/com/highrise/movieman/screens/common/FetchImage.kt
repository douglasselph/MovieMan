/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.screens.common

import android.content.Context
import android.widget.ImageView
import com.highrise.movieman.R
import com.squareup.picasso.Picasso

class FetchImage(private val context: Context) {

    fun installURL(url: String, imageView: ImageView) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .fit()
            .tag(context)
            .into(imageView)
    }

}