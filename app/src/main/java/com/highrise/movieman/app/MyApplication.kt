/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.app

import android.app.Application
import com.highrise.movieman.app.dependencyinjection.CompositionRoot
import com.highrise.movieman.movies.FetchMovieDetailUseCase
import com.highrise.movieman.movies.FetchMovieListUseCase
import com.highrise.movieman.moviesnative.MovieControllerNative
import timber.log.Timber

/**
 * Create application top level elements and the central composition
 * root which will wire these together.
 */
class MyApplication : Application() {

    private val movieControllerNative = MovieControllerNative(10)
    lateinit var compositionRoot: CompositionRoot

    override fun onCreate() {
        super.onCreate()
        compositionRoot = CompositionRoot(
            FetchMovieListUseCase(movieControllerNative),
            FetchMovieDetailUseCase(movieControllerNative),
            this
        )
        Timber.plant(Timber.DebugTree())

    }

}