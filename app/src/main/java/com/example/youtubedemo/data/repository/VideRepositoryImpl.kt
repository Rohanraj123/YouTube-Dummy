package com.example.youtubedemo.data.repository

import android.util.Base64
import android.util.Log
import com.example.youtubedemo.data.model.Video
import com.google.gson.Gson
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from

class VideRepositoryImpl(
    private val supabaseClient: SupabaseClient
): VideoRepository {
    override suspend fun insertVideo(video: Video) {
        try {

            val serializedVideo = serializeVideo(video)

            supabaseClient
                .from("videos")
                .insert(
                    mapOf(
                        "id" to video.id,
                        "thumbnail" to video.thumbnail,
                        "title" to video.title,
                        "likes" to video.likes,
                        "views" to video.views,
                        "video" to video.video.toTypedArray(),
                        "description" to video.description,
                        "comments" to video.comments
                    )
                )
            val response = supabaseClient.from("videos").schema
            Log.d("RepoImpl", "response : $response")
        } catch (e: Exception) {
            Log.d("RepoImpl", "Error inserting video :", e)
        }
    }

    private fun serializeVideo(video: Video): String {
        return Gson().toJson(video.video.map { Base64.encodeToString(it, Base64.DEFAULT) })
    }

    override suspend fun getVideos(): List<Video> {
        TODO("Not yet implemented")
    }

}