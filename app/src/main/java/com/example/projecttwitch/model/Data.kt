package com.example.projecttwitch.model

import com.google.gson.annotations.SerializedName

data class Data<T>(
    @SerializedName("data")
    var data: List<T>
)