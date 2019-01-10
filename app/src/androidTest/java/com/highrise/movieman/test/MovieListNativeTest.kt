package com.highrise.movieman.test

import android.support.test.runner.AndroidJUnit4
import com.highrise.movieman.moviesnative.MovieControllerNative
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieListNativeTest {

    companion object {
        private const val COUNT = 10
    }

    val movieControllerNative = MovieControllerNative(COUNT)

    @Test
    fun testCountOfMoviesCorrect() {
        val movies = movieControllerNative.movies
        Assert.assertEquals(COUNT, movies.size)
    }

    @Test
    fun testMovieNamesAreNotBlank() {
        val movies = movieControllerNative.movies
        for (movie in movies) {
            Assert.assertTrue(movie.name.isNotBlank())
        }
    }

    @Test
    fun testMovieLastUpdatedNotZero() {
        val movies = movieControllerNative.movies
        for (movie in movies) {
            Assert.assertTrue(movie.lastUpdated > 0)
        }
    }
}
