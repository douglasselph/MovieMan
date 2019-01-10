package com.highrise.movieman.app.dependencyinjection

import android.content.Context
import android.view.LayoutInflater
import com.highrise.movieman.movies.FetchMovieDetailUseCase
import com.highrise.movieman.movies.FetchMovieListUseCase
import com.highrise.movieman.screens.common.FetchImage
import com.highrise.movieman.screens.factory.FactoryViewMvc

/**
 * Pure Dependency Injection : wire top level elements together
 *
 * This handles dependency injection in a manner which is easy to understand
 * without needing to research a 3rd party package.
 *
 * That being said, it is perfectly fine to replace the use of this class
 * with an implementation of Dagger II or Koin.
 */
class CompositionRoot(
    val fetchMovieListUseCase: FetchMovieListUseCase,
    val fetchMovieDetailUseCase: FetchMovieDetailUseCase,
    context: Context
) {
    private val layoutInflater = LayoutInflater.from(context)

    val fetchImage = FetchImage(context)
    val factoryViewMvc = FactoryViewMvc(layoutInflater, fetchImage)
}