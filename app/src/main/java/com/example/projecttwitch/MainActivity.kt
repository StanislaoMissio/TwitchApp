package com.example.projecttwitch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    private fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance()

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getGames("PLAYERUNKNOWN'S BATTLEGROUNDS")

        callback.enqueue(object : Callback<Data<Games>> {
            override fun onFailure(call: Call<Data<Games>>, t: Throwable) {
                Log.d("Retrofit Test", t.message.toString())
            }

            override fun onResponse(call: Call<Data<Games>>, response: Response<Data<Games>>) {
                response.body()?.data?.forEach {
                    textView.text = it.id.toString()
                }
            }
        })

    }
}
