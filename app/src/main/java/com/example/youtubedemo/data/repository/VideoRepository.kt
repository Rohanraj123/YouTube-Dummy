package com.example.youtubedemo.data.repository

import com.example.youtubedemo.data.model.videos
import java.io.File

interface VideoRepository {
    suspend fun retrieveVideoUrl(): List<String>
    suspend fun retrieveThumbnailUrl(): List<String>
    suspend fun insertVideo(video: videos)
    suspend fun getVideos(): List<videos>
}