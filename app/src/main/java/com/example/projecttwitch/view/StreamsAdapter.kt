package com.example.projecttwitch.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttwitch.R
import com.example.projecttwitch.model.Data
import com.example.projecttwitch.model.Stream
import com.example.projecttwitch.utils.StringUtils
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

class StreamsAdapter(var streamsList: Data<Stream>) :
    RecyclerView.Adapter<StreamsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(parent.context).inflate(R.layout.streams_view_holder, parent, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return streamsList.data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.username.text = streamsList.data[position].userName
        holder.viewers.text = StringUtils.decimalFormat(streamsList.data[position].viewerCount)
        holder.language.text = StringUtils.language(streamsList.data[position].language)
        holder.title.text = streamsList.data[position].title
//        Picasso
//            .get()
//            .load(streamsList.data[position].)
//            .into(holder.profileImage)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val username: TextView = itemView.findViewById(R.id.username)
        val viewers: TextView = itemView.findViewById(R.id.viewers)
        val language: TextView = itemView.findViewById(R.id.language)
        val title: TextView = itemView.findViewById(R.id.title)
        val profileImage: ImageView = itemView.findViewById(R.id.profile_image)

    }

}