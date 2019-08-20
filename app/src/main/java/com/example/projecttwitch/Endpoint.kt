package com.example.projecttwitch

import com.example.projecttwitch.model.Data
import com.example.projecttwitch.model.Games
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {

    @GET("games")
    fun getGames(@Query("name") name: String): Call<Data<Games>>
}