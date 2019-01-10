/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.screens.moviedetail

import com.highrise.movieman.base.ViewMvc
import com.highrise.movieman.movies.MovieDetail

interface MovieDetailViewMvc : ViewMvc {

    fun bindMovieDetail(movieDetail: MovieDetail)

}