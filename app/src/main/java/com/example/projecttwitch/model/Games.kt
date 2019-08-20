package com.example.projecttwitch.model

import com.google.gson.annotations.SerializedName

data class Games(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)