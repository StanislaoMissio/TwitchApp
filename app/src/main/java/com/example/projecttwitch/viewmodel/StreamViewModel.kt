package com.example.projecttwitch.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projecttwitch.StreamRepository
import com.example.projecttwitch.model.Stream

class StreamViewModel(private val repository: StreamRepository): ViewModel() {

    var streams = MutableLiveData<List<Stream>>()

    fun load() {
        repository.listStreamData({
            streams.value = it
        }, {
            Log.d("Teste View Model", "Failure")
        })
    }

}