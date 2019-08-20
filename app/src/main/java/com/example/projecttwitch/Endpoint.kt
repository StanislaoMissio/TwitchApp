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

    @POST("oauth2/authorize")
    fun getOAuth(
        @Query("client_id") clientId: String,
        @Query("redirect_uri") clientSecret: String,
        @Query("response_type") grantType: String = "code",
        @Query("scope") scope: String = "viewing_activity_read+openid",
        @Query("state") state: String = "c3ab8aa609ea11e793ae92361f002671"
    ): Call<OAuth>

}