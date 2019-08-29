package com.example.projecttwitch.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttwitch.R
import com.example.projecttwitch.model.Data
import com.example.projecttwitch.model.Games
import com.example.projecttwitch.utils.StringUtils
import com.squareup.picasso.Picasso

class GamesAdapter(var games: Data<Games>) : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_games_view_holder, parent, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return games.data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gameName.text = games.data[position].name
        Picasso
            .get()
            .load(StringUtils.formatImageLink(games.data[position].boxArtUrl))
            .fit()
            .into(holder.backgroundGame)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val gameName: TextView = itemView.findViewById(R.id.game_name)
        val backgroundGame: ImageView = itemView.findViewById(R.id.background_game)
    }
}
