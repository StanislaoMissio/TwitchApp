package com.example.projecttwitch.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttwitch.R
import com.example.projecttwitch.api.TwitchApi
import com.example.projecttwitch.model.Data
import com.example.projecttwitch.model.Games
import com.example.projecttwitch.module.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GamesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_games, container, false)
        recyclerView = rootView.findViewById(R.id.games_recycler)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val service =
            RetrofitClient().provideRetrofit(RetrofitClient().provideDefaultOkHttpClient())
                .create(TwitchApi::class.java)
        val call = service.getTopGames()
        call.enqueue(object : Callback<Data<Games>> {
            override fun onFailure(call: Call<Data<Games>>, t: Throwable) {
                Toast.makeText(
                    this@GamesFragment.context,
                    "Something went wrong...Please try later!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<Data<Games>>, response: Response<Data<Games>>) {
                generateDataList(response.body()!!)
            }
        })
    }

    private fun generateDataList(games: Data<Games>) {
        recyclerView.layoutManager = GridLayoutManager(this@GamesFragment.context, 2)
        recyclerView.adapter = GamesAdapter(games)
    }
}
