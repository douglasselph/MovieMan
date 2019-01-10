package com.highrise.movieman.screens.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.highrise.movieman.base.BaseFragment

/**
 * The list of movies
 */
class MovieListFragment : BaseFragment() {

    lateinit var movieListController: MovieListController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val movieListViewMvc = compositionRoot.factoryViewMvc.allocMovieListViewMvc(container)

        movieListController = compositionRoot.allocMovieListController()
        movieListController.viewMvc = movieListViewMvc

        return movieListViewMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        movieListController.onStart()
    }

    override fun onStop() {
        super.onStop()
        movieListController.onStop()

    }
}
