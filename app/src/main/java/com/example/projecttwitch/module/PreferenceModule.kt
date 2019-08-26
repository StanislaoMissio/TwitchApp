package com.example.projecttwitch.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferenceModule = module {

    single { provideSharedPreferences(androidContext()) }

}

const val DEFAULT_SHARED_PREFERENCES = "com.example.settings_preferences"

private fun provideSharedPreferences(app: Context): SharedPreferences =
    app.getSharedPreferences(DEFAULT_SHARED_PREFERENCES, Context.MODE_PRIVATE)