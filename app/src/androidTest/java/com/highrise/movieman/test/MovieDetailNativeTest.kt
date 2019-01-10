/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.test

import android.support.test.runner.AndroidJUnit4
import com.highrise.movieman.moviesnative.MovieControllerNative
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDetailNativeTest {

    companion object {
        private const val COUNT = 5
    }

    val movieControllerNative = MovieControllerNative(COUNT)

    @Test
    fun testMovieDetailQuery() {
        val movies = movieControllerNative.movies
        for (movie in movies) {
            val movieDetail = movieControllerNative.fetchMovieDetail(movie.name)
            Assert.assertTrue(movieDetail != null)
        }
    }

    @Test
    fun testMovieDetailNameOkay() {
        val movies = movieControllerNative.movies
        for (movie in movies) {
            val movieDetail = movieControllerNative.fetchMovieDetail(movie.name)
            Assert.assertTrue(!movieDetail?.name.isNullOrBlank())
        }
    }

    @Test
    fun testMovieDetailDescriptionOkay() {
        val movies = movieControllerNative.movies
        for (movie in movies) {
            val movieDetail = movieControllerNative.fetchMovieDetail(movie.name)
            Assert.assertTrue(!movieDetail?.description.isNullOrBlank())
        }
    }

    @Test
    fun testMovieDetailHasActors() {
        val movies = movieControllerNative.movies
        for (movie in movies) {
            val movieDetail = movieControllerNative.fetchMovieDetail(movie.name)
            Assert.assertTrue(movieDetail?.actors?.isNotEmpty() ?: false)
        }
    }

    @Test
    fun testMovieDetailHasActorNames() {
        val movies = movieControllerNative.movies
        for (movie in movies) {
            val movieDetail = movieControllerNative.fetchMovieDetail(movie.name)
            movieDetail?.let {
                for (actor in it.actors) {
                    Assert.assertTrue(actor.name.isNotBlank())
                }
            }
        }
    }

}
