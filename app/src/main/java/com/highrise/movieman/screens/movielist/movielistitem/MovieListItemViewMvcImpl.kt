/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.screens.movielist.movielistitem

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.highrise.movieman.R
import com.highrise.movieman.base.ObservableViewMvcImpl
import com.highrise.movieman.movies.Movie

class MovieListItemViewMvcImpl(
    inflater: LayoutInflater,
    container: ViewGroup?
) : ObservableViewMvcImpl<MovieListItemViewMvc.Listener>(), MovieListItemViewMvc {

    override val rootView = inflater.inflate(R.layout.movie_list_item, container, false) as ViewGroup

    val textMovieName: TextView = findViewById(R.id.movie_name)

    override fun bindMovie(movie: Movie) {
        textMovieName.text = movie.name
        rootView.setOnClickListener {
            onClick(movie)
        }
    }

    private fun onClick(movie: Movie) {
        for (listener in listeners) {
            listener.onMovieClicked(movie)
        }
    }
}