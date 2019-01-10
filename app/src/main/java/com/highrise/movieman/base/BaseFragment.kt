/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.base

import android.support.v4.app.Fragment
import com.highrise.movieman.app.MyApplication
import com.highrise.movieman.app.dependencyinjection.BoundCompositionRoot
import com.highrise.movieman.app.dependencyinjection.CompositionRoot

open class BaseFragment : Fragment() {

    private val _compositionRoot: CompositionRoot
        get() = (activity!!.applicationContext as MyApplication).compositionRoot

    protected val compositionRoot: BoundCompositionRoot by lazy {
        BoundCompositionRoot(_compositionRoot, activity!!)
    }

}