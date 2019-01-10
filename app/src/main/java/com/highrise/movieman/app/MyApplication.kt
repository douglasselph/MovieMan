/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.app

import android.app.Application
import com.highrise.movieman.app.dependencyinjection.CompositionRoot
import com.highrise.movieman.movies.FetchMovieController

class MyApplication : Application() {

    lateinit var compositionRoot: CompositionRoot

    override fun onCreate() {
        super.onCreate()
        compositionRoot = CompositionRoot(
            FetchMovieController()
        )
    }

}