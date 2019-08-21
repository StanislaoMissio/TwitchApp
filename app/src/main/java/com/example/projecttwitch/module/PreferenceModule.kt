package com.example.projecttwitch.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val preferenceModule = module {

    single { provideSharedPreferences(androidApplication()) }

}

const val DEFAULT_SHARED_PREFERENCES = "com.example.settings_preferences"

private fun provideSharedPreferences(app: Application): SharedPreferences =
    app.getSharedPreferences(DEFAULT_SHARED_PREFERENCES, Context.MODE_PRIVATE)