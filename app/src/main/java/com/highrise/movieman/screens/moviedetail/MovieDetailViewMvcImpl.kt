/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.screens.moviedetail

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.highrise.movieman.R
import com.highrise.movieman.base.ViewMvcImpl
import com.highrise.movieman.movies.MovieDetail
import com.highrise.movieman.screens.factory.FactoryViewMvc
import com.highrise.movieman.screens.parts.SimpleDividerItemDecoration

class MovieDetailViewMvcImpl(
    inflater: LayoutInflater,
    container: ViewGroup?,
    factoryViewMvc: FactoryViewMvc
) : ViewMvcImpl(), MovieDetailViewMvc {

    override val rootView = inflater.inflate(R.layout.movie_detail_frame, container, false) as ViewGroup

    private val titleView: TextView = findViewById(R.id.title)
    private val descriptionView: TextView = findViewById(R.id.description)
    private val actorsRecyclerView: RecyclerView = findViewById(R.id.actor_list)
    private val actorListAdapter = ActorListAdapter(factoryViewMvc)
    private val scoreView: TextView = findViewById(R.id.score)

    init {
        actorsRecyclerView.layoutManager = LinearLayoutManager(context)
        actorsRecyclerView.adapter = actorListAdapter
        actorsRecyclerView.addItemDecoration(SimpleDividerItemDecoration(context))
    }

    override fun bindMovieDetail(movieDetail: MovieDetail) {
        titleView.text = movieDetail.name
        descriptionView.text = movieDetail.description
        actorListAdapter.bindActors(movieDetail.actors)
        scoreView.text = movieDetail.score.toString()
    }
}