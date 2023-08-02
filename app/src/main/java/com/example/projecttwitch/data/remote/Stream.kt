package com.example.projecttwitch.data.remote

import com.google.gson.annotations.SerializedName

data class Stream(
    @SerializedName("id")
    var id: String,
    @SerializedName("game_id")
    var gameId: String,
    @SerializedName("language")
    var language: String,
    @SerializedName("user_id")
    var userId: String,
    @SerializedName("user_name")
    var userName: String,
    @SerializedName("viewer_count")
    var viewerCount: Int,
    @SerializedName("title")
    var title: String
)