package com.example.projecttwitch

import com.example.projecttwitch.model.Stream

interface TwitchDataSource {

    fun listStreamData(success: (List<Stream>) -> Unit, failure: () -> Unit)

}