/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.screens.movielist

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.highrise.movieman.movies.Movie
import com.highrise.movieman.screens.factory.FactoryViewMvc
import com.highrise.movieman.screens.movielist.movielistitem.MovieListItemViewMvc

class MovieListAdapter(
    val factoryViewMvc: FactoryViewMvc,
    val listener: Listener
) : RecyclerView.Adapter<MovieListAdapter.MyViewHolder>(),
    MovieListItemViewMvc.Listener {

    interface Listener {
        fun onMovieClicked(movie: Movie)
    }

    class MyViewHolder(val viewMvc: MovieListItemViewMvc) : RecyclerView.ViewHolder(viewMvc.rootView)

    private var movies: List<Movie> = emptyList()

    fun bindMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder = MyViewHolder(factoryViewMvc.allocMovieListItemViewMvc(parent))
        holder.viewMvc.registerListener(this)
        return holder
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewMvc.bindMovie(movies[position])
    }

    override fun onMovieClicked(movie: Movie) {
        listener.onMovieClicked(movie)
    }
}