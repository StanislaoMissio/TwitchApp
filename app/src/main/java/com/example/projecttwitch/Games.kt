package com.example.projecttwitch

import com.google.gson.annotations.SerializedName

data class Games(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)