/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.movies

import com.highrise.movieman.moviesnative.MovieControllerNative

/**
 * Use Case:
 *   Query the movies from whatever source we want and then supply the caller with the result.
 *
 *   Right now a native call is used in order to acquire the list of movies, but other sources
 *   could be merged in here as well. For example, querying the movies from the network
 *   using retrofit.
 *
 *   If that is to be done, this class should extend BaseObservable and listener scheme would
 *   be employed.
 */
class FetchMovieController {

    val movieControllerNative = MovieControllerNative()

    fun fetchMovies(): List<Movie> {
        return movieControllerNative.movies
    }

    fun fetchString(): String {
        return movieControllerNative.stringFromJNI()
    }
}