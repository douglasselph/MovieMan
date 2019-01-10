/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.screens.factory

import android.view.LayoutInflater
import android.view.ViewGroup
import com.highrise.movieman.screens.common.FetchImage
import com.highrise.movieman.screens.moviedetail.MovieDetailViewMvc
import com.highrise.movieman.screens.moviedetail.MovieDetailViewMvcImpl
import com.highrise.movieman.screens.moviedetail.actoritem.ActorItemViewMvc
import com.highrise.movieman.screens.moviedetail.actoritem.ActorItemViewMvcImpl
import com.highrise.movieman.screens.movielist.MovieListViewMvc
import com.highrise.movieman.screens.movielist.MovieListViewMvcImpl
import com.highrise.movieman.screens.movielist.movielistitem.MovieListItemViewMvc
import com.highrise.movieman.screens.movielist.movielistitem.MovieListItemViewMvcImpl

class FactoryViewMvc(
    private val inflater: LayoutInflater,
    private val fetchImage: FetchImage
) {

    fun allocMovieListViewMvc(container: ViewGroup?): MovieListViewMvc {
        return MovieListViewMvcImpl(inflater, container, this)
    }

    fun allocMovieListItemViewMvc(container: ViewGroup?): MovieListItemViewMvc {
        return MovieListItemViewMvcImpl(inflater, container)
    }

    fun allocActorItemViewMvc(container: ViewGroup?): ActorItemViewMvc {
        return ActorItemViewMvcImpl(inflater, container, fetchImage)
    }

    fun allocMovieDetailViewMvc(container: ViewGroup?): MovieDetailViewMvc {
        return MovieDetailViewMvcImpl(inflater, container, this)
    }

}