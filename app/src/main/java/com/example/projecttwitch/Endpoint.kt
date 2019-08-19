package com.example.projecttwitch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {

    @GET("games")
    fun getGames(@Query("name") name: String): Call<Data<Games>>
}