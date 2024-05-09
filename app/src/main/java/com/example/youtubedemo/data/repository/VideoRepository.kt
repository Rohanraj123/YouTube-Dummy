package com.example.youtubedemo.data.repository

import com.example.youtubedemo.data.model.Video

interface VideoRepository {
    suspend fun insertVideo(video: Video)
    suspend fun getVideos(): List<Video>
}