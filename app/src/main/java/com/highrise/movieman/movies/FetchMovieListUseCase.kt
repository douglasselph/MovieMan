/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.movies

import com.highrise.movieman.moviesnative.MovieControllerNative

/**
 * Use Case:
 *   Query the movies from whatever source we want and then supply the caller with the result.
 *   Right now the sources are just native sources. But in theory other sources could be arranged.
 *   For example from the web.
 *
 * Note:
 *   In order to preserve proper separation of concerns we have both MovieNative and Movie classes
 *   and we take the time to convert between these. The Movie class is the system object used in the
 *   screen controls and UI logic. The MovieNative object is restricted to the native representation.
 *
 *   For example, if in the UI we wanted to have an "expanded" state when displaying the movie line,
 *   we could simply add 'expanded' to the Movie class, since the Movie class's purpose to management
 *   of UI logic. By doing this however, we don't affect elements which are not concerned with that,
 *   namely the fetch of the movie object from the native source, which has nothing to do with UI logic.
 */
class FetchMovieListUseCase(val movieControllerNative: MovieControllerNative) {

    fun fetchMovies(): List<Movie> {
        val native = movieControllerNative.movies
        val movies = mutableListOf<Movie>()
        for (movie in native) {
            movies.add(Movie(movie.name, movie.lastUpdated))
        }
        return movies
    }

}