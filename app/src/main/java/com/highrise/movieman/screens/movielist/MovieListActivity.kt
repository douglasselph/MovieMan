/*
 * Copyright @  2019  Douglas Selph
 */

/**
 * Douglas Selph Jan 2019
 */
package com.highrise.movieman.screens.movielist

import android.os.Bundle

import kotlinx.android.synthetic.main.movie_list_activity.*
import com.highrise.movieman.R
import com.highrise.movieman.base.BaseActivity

class MovieListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_list_activity)
        setSupportActionBar(toolbar)
    }

}
