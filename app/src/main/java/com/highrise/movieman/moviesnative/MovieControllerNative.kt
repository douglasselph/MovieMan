/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.moviesnative

import com.highrise.movieman.movies.Movie
import com.highrise.movieman.movies.MovieDetail

/**
 * Extract the list of movies from a native call.
 *
 * Returned as a List<Movie>.
 *
 * Thought: a more formal approach here would be to have this class
 * only know about it's version of class Movie. That is a class
 * called MovieNative. Then the FetchMovieListUseCase would do a translation
 * from that into the system's Movie. The advantage of that approach
 * is it would encapsulate native movie fetches from the rest of the
 * system and visa versa. I am not doing that here, because that could
 * be considered a future enhancement as the system grows in complexity.
 */
class MovieControllerNative(count: Int) {

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    private external fun create(count: Int): Long
    private external fun getMovieCount(session: Long): Int
    private external fun getMovieName(session: Long, offset: Int): String
    private external fun getMovieLastUpdated(session: Long, offset: Int): Int
    private external fun getMovieDetailToken(session: Long, name: String): Long
    private external fun getMovieDetailName(token: Long): String
    private external fun getMovieDetailDescription(token: Long): String
    private external fun getMovieDetailScore(token: Long): Float
    private external fun getMovieDetailActorCount(token: Long): Int
    private external fun getMovieDetailActorName(token: Long, offset: Int): String
    private external fun getMovieDetailActorImage(token: Long, offset: Int): String
    private external fun getMovieDetailActorAge(token: Long, offset: Int): Int

    private val session: Long // Session pointer for the parallel object in NDK world

    init {
        session = create(count)
    }

    val movies: List<MovieNative> by lazy {
        fetchMovies()
    }

    private fun fetchMovies(): List<MovieNative> {
        val list = ArrayList<MovieNative>()
        val count = getMovieCount(session)

        for (offset in 0 until count) {
            val name = getMovieName(session, offset)
            val lastUpdated = getMovieLastUpdated(session, offset)
            list.add(MovieNative(name, lastUpdated))
        }
        return list
    }

    fun fetchMovieDetail(name: String): MovieDetailNative? {
        val token = getMovieDetailToken(session, name)
        if (token == 0L) {
            return null
        }
        val detailName = getMovieDetailName(token)
        val detailDescription = getMovieDetailDescription(token)
        val score = getMovieDetailScore(token)
        val actorCount = getMovieDetailActorCount(token)
        val actorList = mutableListOf<ActorNative>()
        for (i in 0 until actorCount) {
            val actorName = getMovieDetailActorName(token, i)
            val actorImage = getMovieDetailActorImage(token, i)
            val actorAge = getMovieDetailActorAge(token, i)
            val actor = ActorNative(actorName, actorAge, actorImage)
            actorList.add(actor)
        }
        return MovieDetailNative(detailName, detailDescription, score, actorList)
    }

}