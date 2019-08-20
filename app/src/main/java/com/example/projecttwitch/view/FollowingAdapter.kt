package com.example.projecttwitch.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttwitch.R
import com.example.projecttwitch.model.User
import kotlinx.android.synthetic.main.following_viewholder.view.*

class FollowingAdapter(var followingList: ArrayList<User>) : RecyclerView.Adapter<FollowingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context).inflate(R.layout.following_viewholder, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return followingList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = followingList[position].name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textView = itemView.text_view

    }
}