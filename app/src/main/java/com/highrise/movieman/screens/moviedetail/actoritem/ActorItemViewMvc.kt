/*
 * Copyright @  2019  Douglas Selph
 */

package com.highrise.movieman.screens.moviedetail.actoritem

import com.highrise.movieman.base.ViewMvc
import com.highrise.movieman.movies.Actor

interface ActorItemViewMvc : ViewMvc {

    fun bindActor(actor: Actor)

}