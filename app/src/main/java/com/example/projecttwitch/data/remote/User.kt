package com.example.projecttwitch.data.remote

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    var name: String
)