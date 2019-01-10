/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.app.dependencyinjection

import android.support.v4.app.FragmentActivity
import com.highrise.movieman.movies.FetchMovieDetailUseCase
import com.highrise.movieman.screens.common.ScreenNavigator
import com.highrise.movieman.screens.factory.FactoryViewMvc
import com.highrise.movieman.screens.movielist.MovieListController

/**
 * The composition root bound to the a particular activity
 */
class BoundCompositionRoot(
    val compositionRoot: CompositionRoot,
    val activity: FragmentActivity
) {

    val factoryViewMvc: FactoryViewMvc
        get() = compositionRoot.factoryViewMvc

    val fetchMovieDetailUseCase: FetchMovieDetailUseCase
        get() = compositionRoot.fetchMovieDetailUseCase

    fun allocMovieListController(): MovieListController {
        return MovieListController(compositionRoot.fetchMovieListUseCase, allocScreenNavigator())
    }

    fun allocScreenNavigator(): ScreenNavigator {
        return ScreenNavigator(activity)
    }
}