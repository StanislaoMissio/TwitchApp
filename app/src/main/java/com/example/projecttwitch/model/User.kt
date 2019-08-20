package com.example.projecttwitch.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    var name: String
)
