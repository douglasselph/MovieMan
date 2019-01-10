/*
 * Copyright @  2019  Douglas Selph
 */

/**
 * Douglas Selph Jan 2019
 */
package com.highrise.movieman.screens.moviedetail

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem

import kotlinx.android.synthetic.main.movie_list_activity.*
import com.highrise.movieman.R
import com.highrise.movieman.base.BaseActivity
import com.highrise.movieman.movies.Movie
import com.highrise.movieman.screens.common.ScreenNavigator

class MovieDetailActivity : BaseActivity() {

    companion object {

        private const val ARG_MOVIE_NAME = "movie_name"

        fun newInstance(from: Activity, movie: Movie) {
            val intent = Intent(from, MovieDetailActivity::class.java)
            val bundle = Bundle()
            bundle.putString(ARG_MOVIE_NAME, movie.name)
            intent.putExtras(bundle)
            from.startActivity(
                intent, ActivityOptions.makeSceneTransitionAnimation(from).toBundle()
            )
        }
    }

    val movieDetailFragment: MovieDetailFragment
        get() = fragment as MovieDetailFragment

    lateinit var screenNavigator: ScreenNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail_activity)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val movieName = intent.extras?.getString(ARG_MOVIE_NAME)
        movieName?.let {
            movieDetailFragment.bindMovieDetail(it)
        }
        screenNavigator = compositionRoot.allocScreenNavigator()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                screenNavigator.navigateUp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
