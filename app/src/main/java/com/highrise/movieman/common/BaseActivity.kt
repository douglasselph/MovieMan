/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.common

import android.support.v7.app.AppCompatActivity
import com.highrise.movieman.app.MyApplication
import com.highrise.movieman.app.dependencyinjection.CompositionRoot

open class BaseActivity : AppCompatActivity() {

    val compositionRoot: CompositionRoot by lazy {
        (applicationContext as MyApplication).compositionRoot
    }

}