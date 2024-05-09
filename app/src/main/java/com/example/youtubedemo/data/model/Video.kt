package com.example.youtubedemo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Video(
    val id: Int,
    val thumbnail: String,
    val title: String,
    val likes: Int,
    val views: Int,
    val video: String,
    val description: String
)