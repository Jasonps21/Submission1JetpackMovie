package com.jason.movietvcatalog.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jason.movietvcatalog.R
import com.jason.movietvcatalog.data.ActorEntity
import kotlinx.android.synthetic.main.items_actor.view.*

class DetailMovieAdapter : RecyclerView.Adapter<DetailMovieAdapter.ActorViewHolder>() {
    private val listActor = ArrayList<ActorEntity>()
    fun setActor(actor: List<ActorEntity>?) {
        if (actor == null) return
        listActor.clear()
        listActor.addAll(actor)
    }

    class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(actor: ActorEntity) {
            with(itemView) {
                name_actor.text = actor.actor_name
                name_player_actor.text = actor.actor_player
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_actor, parent, false)
        return ActorViewHolder(view)
    }

    override fun getItemCount(): Int = listActor.size

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val module = listActor[position]
        holder.bind(module)
    }
}