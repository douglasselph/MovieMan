/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.base

import android.support.v7.app.AppCompatActivity
import com.highrise.movieman.app.MyApplication
import com.highrise.movieman.app.dependencyinjection.BoundCompositionRoot
import com.highrise.movieman.app.dependencyinjection.CompositionRoot

open class BaseActivity : AppCompatActivity() {

    private val _compositionRoot: CompositionRoot
        get() = (applicationContext as MyApplication).compositionRoot

    protected val compositionRoot: BoundCompositionRoot by lazy {
        BoundCompositionRoot(_compositionRoot, this)
    }

}