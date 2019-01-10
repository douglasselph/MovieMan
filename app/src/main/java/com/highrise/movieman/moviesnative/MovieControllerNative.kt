/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.moviesnative

import com.highrise.movieman.movies.Movie

/**
 * Extract the list of movies from a native call.
 *
 * Note: Right now the movies are returned as a List<Movie>, which
 * doesn't encapsulate the calls here from affecting other parts of the
 * system. That is, perhaps a MovieNative class could be created to act
 * as a buffer and that would be passed back. That way changes to the
 * requirements of "Movie" used in the system would not affect
 * changes to native movie handling and visa versa.
 */
class MovieControllerNative {

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    private external fun create(): Long
    private external fun getMovieCount(session: Long): Int
    private external fun getMovieName(token: Long, offset: Int): String
    external fun stringFromJNI(): String

    private val session: Long // Session pointer for the parallel object in NDK world

    init {
        session = create()
    }

    val movies: List<Movie> by lazy {
        fetchMovies()
    }

    private fun fetchMovies(): List<Movie> {
        val list = ArrayList<Movie>()
        val count = getMovieCount(session)

        for (offset in 0 until count) {
            val name = getMovieName(session, offset)
            list.add(Movie(name, 0))
        }
        return list
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

}