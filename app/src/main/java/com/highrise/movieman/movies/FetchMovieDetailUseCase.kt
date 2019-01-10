/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.movies

import com.highrise.movieman.moviesnative.MovieControllerNative

/**
 * Use Case:
 *   Query the movie detail
 *
 *
 * Note:
 *   In order to preserve proper separation of concerns we have both MovieDetailNative and MovieDetail classes
 *   and we take the time to convert between these. The MovieDetail class is the system object used in the
 *   screen controls and UI logic. The MovieDetailNative object is restricted to the native representation.
 */
class FetchMovieDetailUseCase(val movieControllerNative: MovieControllerNative) {

    class MovieDetailException : Exception()

    fun fetchMovieDetail(name: String): MovieDetail {
        val native = movieControllerNative.fetchMovieDetail(name)
        native?.let {
            val actorList = mutableListOf<Actor>()
            for (actor in native.actors) {
                actorList.add(Actor(actor.name, actor.age, actor.imageUrl))
            }
            return MovieDetail(native.name, native.description, native.score, actorList)
        } ?: throw MovieDetailException()
    }

}