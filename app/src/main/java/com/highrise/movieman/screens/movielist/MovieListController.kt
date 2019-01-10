/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.screens.movielist

import com.highrise.movieman.movies.FetchMovieListUseCase
import com.highrise.movieman.movies.Movie
import com.highrise.movieman.screens.common.ScreenNavigator

class MovieListController(
    private val fetchMovieListUseCase: FetchMovieListUseCase,
    private val screenNavigator: ScreenNavigator
) : MovieListViewMvc.Listener {

    lateinit var viewMvc: MovieListViewMvc

    fun onStart() {
        viewMvc.bindMovies(fetchMovieListUseCase.fetchMovies())
        viewMvc.registerListener(this)
    }

    fun onStop() {
        viewMvc.unregisterListener(this)
    }

    override fun onMovieClicked(movie: Movie) {
        screenNavigator.toMovieDetail(movie)
    }
}
