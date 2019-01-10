/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.base

import java.util.Collections
import java.util.HashSet

/**
 * Thought: perhaps use java.util.Observable for added functionality.
 */
abstract class ObservableViewMvcImpl<ListenerType> : ViewMvcImpl(), ObservableViewMvc<ListenerType> {

    private val mListeners = HashSet<ListenerType>()

    protected val listeners: Set<ListenerType>
        get() = Collections.unmodifiableSet(mListeners)

    override fun registerListener(listener: ListenerType) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: ListenerType) {
        mListeners.remove(listener)
    }
}
