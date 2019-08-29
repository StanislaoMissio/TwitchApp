package com.example.projecttwitch.model

data class Stream(
    var id: String,
    var gameId: String,
    var language: String,
    var userId: String,
    var userName: String,
    var viewerCount: Int,
    var title: String
)