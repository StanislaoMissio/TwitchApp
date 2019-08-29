package com.example.projecttwitch.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttwitch.R
import com.example.projecttwitch.api.TwitchApi
import com.example.projecttwitch.model.Data
import com.example.projecttwitch.model.Stream
import com.example.projecttwitch.module.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LiveFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_lives, container, false)
        recyclerView = rootView.findViewById(R.id.lives_recycler)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val service =
            RetrofitClient().provideRetrofit(RetrofitClient().provideDefaultOkHttpClient())
                .create(TwitchApi::class.java)
        val call = service.getStreams()
        call.enqueue(object : Callback<Data<Stream>> {
            override fun onFailure(call: Call<Data<Stream>>, t: Throwable) {
                Toast.makeText(
                    this@LiveFragment.context,
                    "Something went wrong...Please try later!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<Data<Stream>>, response: Response<Data<Stream>>) {
                generateDataList(response.body()!!)
            }
        })

    }

    private fun generateDataList(streams: Data<Stream>) {
        recyclerView.layoutManager = LinearLayoutManager(this@LiveFragment.context)
        recyclerView.adapter = StreamsAdapter(streams)
    }

}
