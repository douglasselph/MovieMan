/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.screens.moviedetail.actoritem

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.highrise.movieman.R
import com.highrise.movieman.base.ViewMvcImpl
import com.highrise.movieman.movies.Actor
import com.highrise.movieman.screens.common.FetchImage
import timber.log.Timber

class ActorItemViewMvcImpl(
    inflater: LayoutInflater,
    container: ViewGroup?,
    private val fetchImage: FetchImage
) : ViewMvcImpl(), ActorItemViewMvc {

    override val rootView = inflater.inflate(R.layout.actor_item, container, false) as ViewGroup

    private val nameView = findViewById<TextView>(R.id.name)
    private val imageView = findViewById<ImageView>(R.id.image)
    private val ageView = findViewById<TextView>(R.id.age)

    override fun bindActor(actor: Actor) {
        nameView.text = actor.name
        ageView.text = actor.age.toString()
        with (actor) {
            if (imageUrl.isNotBlank()) {
                Timber.d("IMAGE=$imageUrl")
                fetchImage.installURL(imageUrl, imageView)
            }
        }
    }
}