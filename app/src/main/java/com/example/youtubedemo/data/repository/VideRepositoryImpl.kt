package com.example.youtubedemo.data.repository

import com.example.youtubedemo.data.model.Video
import io.github.jan.supabase.SupabaseClient

class VideRepositoryImpl(
    private val supabaseClient: SupabaseClient
): VideoRepository {
    override suspend fun insertVideo(video: Video) {

    }


    override suspend fun getVideos(): List<Video> {
        TODO("Not yet implemented")
    }

}