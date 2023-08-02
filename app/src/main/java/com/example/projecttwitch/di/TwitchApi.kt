package com.example.projecttwitch.di

import com.example.projecttwitch.data.remote.OAuth
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface TwitchApi {

    @POST("oauth2/token")
    suspend fun getOAuth(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("code") code: String?,
        @Query("grant_type") grantType: String = "authorization_code",
        @Query("redirect_uri") redirectUri: String = "https://localhost/"
    ): Call<OAuth>

}