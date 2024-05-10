package com.example.youtubedemo.data.repository

import android.util.Log
import com.example.youtubedemo.data.model.videos
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.storage.storage
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.json.JSONArray

class VideRepositoryImpl(
    private val supabaseClient: SupabaseClient
): VideoRepository {
    override suspend fun retrieveVideoUrl(): List<String> {
        val url8 = supabaseClient.storage.from("Video").publicUrl("video8.mp4")
        val url7 = supabaseClient.storage.from("Video").publicUrl("video7.mp4")
        val url6 = supabaseClient.storage.from("Video").publicUrl("video7.mp4")
        return listOf(url6, url7, url8)
    }

    override suspend fun retrieveThumbnailUrl(): List<String> {
        val url8 = supabaseClient.storage.from("Thumbnail").publicUrl("thumbnail8.jpg")
        val url7 = supabaseClient.storage.from("Thumbnail").publicUrl("thumbnail7.jpg")
        val url6 = supabaseClient.storage.from("Thumbnail").publicUrl("thumbnail6.jpg")
        return listOf(url6, url7, url8)
    }


    override suspend fun insertVideo(video: videos) {
        val id = Json.encodeToString(video.id)
        val thumbnail = Json.encodeToString(video.thumbnail)
        val title = Json.encodeToString(video.title)
        val likes = Json.encodeToString(video.likes)
        val views = Json.encodeToString(video.views)
        val videos = Json.encodeToString(video.video)
        val description = Json.encodeToString(video.description)
        try {
            val data = mapOf(
                "id" to id,
                "thumbnail" to thumbnail,
                "title" to title,
                "likes" to likes,
                "views" to views,
                "video" to videos,
                "description" to description
            )
            supabaseClient.from("videos").insert(data)
        } catch (e: Exception) {
            Log.e("VideoRepositoryImpl", "Exception: ${e.message}")
        }
    }


    override suspend fun getVideos(): List<videos> {
        try {
            val result = supabaseClient.from("videos").select()
            val responseBody = result.data
            responseBody.let {
                val jsonString = it
                val jsonArray = JSONArray(jsonString)
                val videoList = mutableListOf<videos>()
                for (i in 0 until jsonArray.length()) {
                    val jsonMap = jsonArray.getJSONObject(i)
                    val id = jsonMap.getInt("id")
                    val thumbnail = jsonMap.getString("thumbnail")
                    val title = jsonMap.getString("title")
                    val likes = jsonMap.getInt("likes")
                    val views = jsonMap.getInt("views")
                    val video = jsonMap.getString("video")
                    val description = jsonMap.getString("description")
                    val videoObj = videos(id, thumbnail, title, likes, views, video, description)
                    videoList.add(videoObj)
                }
                return videoList
            }
        } catch (e: Exception) {
            throw e
        }

    }
}