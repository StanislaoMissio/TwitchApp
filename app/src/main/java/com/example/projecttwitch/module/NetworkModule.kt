package com.example.projecttwitch.module

import com.example.projecttwitch.BuildConfig
import com.example.projecttwitch.Endpoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideDefaultOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideEndpoint(get()) }
}

fun provideDefaultOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor {
            val original = it.request()
            val request = original.newBuilder()
                .header(
                    BuildConfig.CLIENT_ID,
                    BuildConfig.KEY_CLIENT_ID
                )
                .build()
            it.proceed(request)
        }
        .build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_OAUTH)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun provideEndpoint(retrofit: Retrofit): Endpoint = retrofit.create(Endpoint::class.java)

val interceptor = HttpLoggingInterceptor().apply {
    this.level = HttpLoggingInterceptor.Level.BODY
}