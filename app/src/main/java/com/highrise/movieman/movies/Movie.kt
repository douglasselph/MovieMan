/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.movies

/**
 * Handle the system/UI side of a movie.
 *
 * The reason this is not MovieNative is let's say we wanted to place the movie details
 * beneath the movie list line when it is clicked on instead of invoking another screen.
 * The way we would implement that is to add an 'expanded' boolean here in this class
 * and trigger the UI changes off of that. The MovieNative class would be untouched
 * as it should be because UI state should not be held with that class.
 */
class Movie(
    val name: String,
    val lastUpdated: Int
)