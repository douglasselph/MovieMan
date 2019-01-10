/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.screens.movielist

import com.highrise.movieman.base.ObservableViewMvc
import com.highrise.movieman.movies.Movie

interface MovieListViewMvc : ObservableViewMvc<MovieListViewMvc.Listener> {

    interface Listener {
        fun onMovieClicked(movie: Movie)
    }

    fun bindMovies(movies: List<Movie>)

}
