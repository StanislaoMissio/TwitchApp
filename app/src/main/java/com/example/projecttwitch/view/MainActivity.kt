package com.example.projecttwitch.view

import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.projecttwitch.BuildConfig.CLIENT_SECRET
import com.example.projecttwitch.BuildConfig.KEY_CLIENT_ID
import com.example.projecttwitch.Endpoint
import com.example.projecttwitch.R
import com.example.projecttwitch.model.OAuth
import com.example.projecttwitch.module.networkModule
import com.example.projecttwitch.module.preferenceModule
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val endpoint: Endpoint by inject()

    private val preferences: SharedPreferences by inject()
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidContext(this@MainActivity)
            modules(networkModule, preferenceModule)
        }
        val url =
            "https://id.twitch.tv/oauth2/authorize?response_type=code&client_id=$KEY_CLIENT_ID&redirect_uri=https://localhost/&scope=viewing_activity_read+openid&state=c3ab8aa609ea11e793ae92361f002671"
        oauth.setOnClickListener {
            webview.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    val code = "code="
                    if (url!!.contains(code)) {
                        // the GET request contains an authorization code
                        val accessCode = url.substringAfter(code).substringBefore("&")

                        editor = preferences.edit()
                        editor.putString("code", accessCode).apply()
                    }
                }
            }
            webview.loadUrl(url)
        }

        val callback = endpoint.getOAuth(KEY_CLIENT_ID, CLIENT_SECRET, preferences.getString("code", null))
        callback.enqueue(object : Callback<OAuth> {
            override fun onFailure(call: Call<OAuth>, t: Throwable) {
                Log.d("Retrofit Test", t.message.toString())
            }

            override fun onResponse(call: Call<OAuth>, response: Response<OAuth>) {
                editor = preferences.edit()
                editor.putString("access_token", response.body()?.accessToken)
                editor.putString("token_type", response.body()?.tokenType)
                editor.putString("refresh_token", response.body()?.refreshToken)
                editor.apply()
            }
        })
    }
}
