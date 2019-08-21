package com.example.projecttwitch

import com.example.projecttwitch.model.Data
import com.example.projecttwitch.model.Games
import com.example.projecttwitch.model.OAuth
import com.example.projecttwitch.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Endpoint {

    @GET("games")
    fun getGames(@Query("name") name: String): Call<Data<Games>>

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

}