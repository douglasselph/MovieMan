/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.screens.movielist.movielistitem

import com.highrise.movieman.base.ObservableViewMvc
import com.highrise.movieman.movies.Movie

interface MovieListItemViewMvc : ObservableViewMvc<MovieListItemViewMvc.Listener> {

    interface Listener {
        fun onMovieClicked(movie: Movie)
    }

    fun bindMovie(movie: Movie)

}