package com.example.projecttwitch.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projecttwitch.Endpoint
import com.example.projecttwitch.R
import com.example.projecttwitch.module.networkModule
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MainActivity : AppCompatActivity() {

    private val endpoint: Endpoint by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidContext(this@MainActivity)
            modules(networkModule)
        }
        oauth.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data =
                Uri.parse("https://id.twitch.tv/oauth2/authorize?response_type=code&client_id=3vei2jegmxt932jdsh0saduhtkgul0&redirect_uri=https://localhost/&scope=viewing_activity_read+openid&state=c3ab8aa609ea11e793ae92361f002671")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}
