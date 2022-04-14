package com.dewatwc.movies.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dewatwc.movies.R
import com.dewatwc.movies.data.source.local.movie.PlayerMovies
import kotlinx.android.synthetic.main.items_player_list.view.*

import java.util.ArrayList

class DetailMoviesAdapter : RecyclerView.Adapter<DetailMoviesAdapter.PlayerViewHolder>() {

    private val listPlayer = ArrayList<PlayerMovies>()

    fun setPlayer(player: List<PlayerMovies>?) {
        if (player == null) return
        this.listPlayer.clear()
        this.listPlayer.addAll(player)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_player_list, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: PlayerViewHolder, position: Int) {
        val player = listPlayer[position]
        viewHolder.bind(player)
    }

    override fun getItemCount(): Int = listPlayer.size

    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(player: PlayerMovies) {
            with(itemView) {
                text_player_title.text = player.title
            }
        }
    }
}

