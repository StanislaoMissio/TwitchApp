package com.example.projecttwitch.model

import com.google.gson.annotations.SerializedName

data class OAuth(
    @SerializedName("access_token")
    var accessToken: String,
    @SerializedName("token_type")
    var tokenType: String
)