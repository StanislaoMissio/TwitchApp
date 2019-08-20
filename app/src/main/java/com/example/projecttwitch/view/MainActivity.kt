package com.example.projecttwitch.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.projecttwitch.Endpoint
import com.example.projecttwitch.R
import com.example.projecttwitch.model.Data
import com.example.projecttwitch.model.Games
import com.example.projecttwitch.module.networkModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val endpoint: Endpoint by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidContext(this@MainActivity)
            modules(networkModule)
        }
        getData()
    }

    private fun getData() {
        val callback = endpoint.getGames("PLAYERUNKNOWN'S BATTLEGROUNDS")

        callback.enqueue(object : Callback<Data<Games>> {
            override fun onFailure(call: Call<Data<Games>>, t: Throwable) {
                Log.d("Retrofit Test", t.message.toString())
            }

            override fun onResponse(call: Call<Data<Games>>, response: Response<Data<Games>>) {
                response.body()?.data?.forEach {}
            }
        })

    }
}
