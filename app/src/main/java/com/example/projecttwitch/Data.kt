package com.example.projecttwitch

import com.google.gson.annotations.SerializedName

data class Data<T>(
    @SerializedName("data")
    var data: List<T>
)