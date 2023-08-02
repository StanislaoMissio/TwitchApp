package com.example.projecttwitch.data.remote

import com.google.gson.annotations.SerializedName

data class Games(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("box_art_url")
    var boxArtUrl: String
)