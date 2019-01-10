/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.screens.common

import android.app.Activity
import com.highrise.movieman.movies.Movie
import com.highrise.movieman.screens.moviedetail.MovieDetailActivity

class ScreenNavigator(val activity: Activity) {

     fun toMovieDetail(movie: Movie) {
         MovieDetailActivity.newInstance(activity, movie)
     }

    fun navigateUp() {
        activity.finish()
    }

}