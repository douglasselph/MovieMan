/*
 * Copyright @  2019  Douglas Selph
 */
package com.highrise.movieman.screens.moviedetail

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.highrise.movieman.movies.Actor
import com.highrise.movieman.screens.factory.FactoryViewMvc
import com.highrise.movieman.screens.moviedetail.actoritem.ActorItemViewMvc

class ActorListAdapter(
    val factoryViewMvc: FactoryViewMvc
) : RecyclerView.Adapter<ActorListAdapter.MyViewHolder>() {

    class MyViewHolder(val viewMvc: ActorItemViewMvc) : RecyclerView.ViewHolder(viewMvc.rootView)

    private var actors: List<Actor> = emptyList()

    fun bindActors(actors: List<Actor>) {
        this.actors = actors
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(factoryViewMvc.allocActorItemViewMvc(parent))
    }

    override fun getItemCount(): Int {
        return actors.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewMvc.bindActor(actors[position])
    }

}