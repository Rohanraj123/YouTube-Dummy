package com.example.youtubedemo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val id: Int,
    val videoId: Int,
    val commentText: String,
    val userId: Int,
    val timeStamp: Long
)
