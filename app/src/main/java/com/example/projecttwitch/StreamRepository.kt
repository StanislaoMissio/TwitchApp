package com.example.projecttwitch

import com.example.projecttwitch.model.Stream

class StreamRepository(private val source: TwitchDataSource): TwitchDataSource {

    override fun listStreamData(success: (List<Stream>) -> Unit, failure: () -> Unit) {
        source.listStreamData(success, failure)
    }

}