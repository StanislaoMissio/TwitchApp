package com.example.projecttwitch.api

import com.example.projecttwitch.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TwitchApi {

    @GET("games")
    fun getGames(@Query("id") id: String): Call<Data<Games>>

    @GET("users")
    fun getUsers(): Call<Data<User>>

    @POST("oauth2/token")
    fun getOAuth(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("code") code: String?,
        @Query("grant_type") grantType: String = "authorization_code",
        @Query("redirect_uri") redirectUri: String = "https://localhost/"
    ): Call<OAuth>

    @GET("streams")
    fun getStreams(): Call<Data<Stream>>

}