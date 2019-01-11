/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.screens.movielist

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.highrise.movieman.R
import com.highrise.movieman.base.ObservableViewMvcImpl
import com.highrise.movieman.movies.Movie
import com.highrise.movieman.screens.factory.FactoryViewMvc
import com.highrise.movieman.screens.uiparts.SimpleDividerItemDecoration

class MovieListViewMvcImpl(
    inflater: LayoutInflater,
    container: ViewGroup?,
    factoryViewMvc: FactoryViewMvc
) : ObservableViewMvcImpl<MovieListViewMvc.Listener>(), MovieListViewMvc, MovieListAdapter.Listener {

    override val rootView = inflater.inflate(R.layout.movie_list_frame, container, false) as ViewGroup

    val recyclerView: RecyclerView = findViewById(R.id.movie_list)
    val movieListAdapter = MovieListAdapter(factoryViewMvc, this)

    init {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = movieListAdapter
        recyclerView.addItemDecoration(SimpleDividerItemDecoration(context))
    }

    override fun bindMovies(movies: List<Movie>) {
        movieListAdapter.bindMovies(movies)
    }

    override fun onMovieClicked(movie: Movie) {
        for (listener in listeners) {
            listener.onMovieClicked(movie)
        }
    }
}