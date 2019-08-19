package com.example.projecttwitch

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {

        private const val BASE_URL = "https://api.twitch.tv/helix/"
        private const val CLIENT_ID = "Client-ID"
        private const val KEY_CLIENT_ID = "3vei2jegmxt932jdsh0saduhtkgul0"

        fun getRetrofitInstance(): Retrofit {
            val interceptor = HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }

            val client: OkHttpClient = OkHttpClient.Builder().apply {
                this.addInterceptor(interceptor)
                this.addInterceptor {
                    val original = it.request()
                    val request = original.newBuilder()
                        .header(CLIENT_ID, KEY_CLIENT_ID)
                        .build()
                    it.proceed(request)
                }
            }.build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

    }
}