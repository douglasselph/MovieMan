/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.base

interface ObservableViewMvc<ListenerType> : ViewMvc {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)

}
