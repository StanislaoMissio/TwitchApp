package com.example.projecttwitch

import android.util.Log
import com.example.projecttwitch.model.Data
import com.example.projecttwitch.model.Stream
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StreamDataSource(private val twitchApi: TwitchApi) : TwitchDataSource {

    override fun listStreamData(success: (List<Stream>) -> Unit, failure: () -> Unit) {
        val call = twitchApi.getStreams()

        call.enqueue(object : Callback<Data<Stream>> {

            override fun onFailure(call: Call<Data<Stream>>, t: Throwable) {
                Log.d("Error on call API", t.message!!)
                failure()
            }

            override fun onResponse(call: Call<Data<Stream>>, response: Response<Data<Stream>>) {
                if (response.isSuccessful) {
                    val streams = mutableListOf<Stream>()
                    response.body()?.data?.forEach {
                        streams.add(
                            Stream(
                                id = it.id,
                                gameId = it.gameId,
                                language = it.language,
                                title = it.title,
                                userId = it.userId,
                                userName = it.userName,
                                viewerCount = it.viewerCount
                            )
                        )
                    }
                    success(streams)
                } else {
                    failure()
                }
            }

        })
    }

}