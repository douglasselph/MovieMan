/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.screens.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.highrise.movieman.base.BaseFragment
import com.highrise.movieman.movies.MovieDetail

class MovieDetailFragment : BaseFragment() {

    private lateinit var viewMvc: MovieDetailViewMvc
    private var movieDetail: MovieDetail? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewMvc = compositionRoot.factoryViewMvc.allocMovieDetailViewMvc(container)
        return viewMvc.rootView
    }

    fun bindMovieDetail(name: String) {
        movieDetail = compositionRoot.fetchMovieDetailUseCase.fetchMovieDetail(name)
        movieDetail?.let {
            viewMvc.bindMovieDetail(it)
        }
    }

}