package com.example.youtubedemo.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubedemo.R
import com.example.youtubedemo.data.model.Comment
import com.example.youtubedemo.data.model.Video
import com.example.youtubedemo.data.repository.VideoRepository
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.result.PostgrestResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class SupaBaseViewModel @Inject constructor(
    @SuppressLint("StaticFieldLeak") @ApplicationContext val context: Context,
    private val supabaseClient: SupabaseClient,
    private val videoRepository: VideoRepository
): ViewModel() {

    // For thumbnail
    val thumbnailBitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.raw.thumbnail1)

    fun insertVideo(video: Video) {
        viewModelScope.launch {
            try {
                val commentJson = video.comments.toJson()
                videoRepository.insertVideo(video.copy(comments = emptyList()))
                Log.d("ViewModel", "insertVideo of repo is called with comments $commentJson")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun insertSampleVideos() {
        for (i in 0..1) {
            val sampleVideo = createSampleVideo(i)
            Log.d("viewmodel", "sample video : $sampleVideo")
            insertVideo(sampleVideo)
            Log.d("ViewModel", "insertVideo method is called")
        }
    }
    private fun createSampleVideo(id: Int): Video {
        val comments = generateCommentsForVideo(id)

        val videoChunks = loadVideoChunks(R.raw.video1)

        return Video(
            id = id,
            thumbnail = thumbnailBitmap.toByteArray(),
            title = "Sample Video ",
            likes = 0,
            views = 0,
            video = videoChunks,
            description = "This is a sample video description",
            comments = comments
        )
    }

    private fun loadVideoChunks(videoResourceId: Int): List<ByteArray> {
        val inputStream: InputStream = context.resources.openRawResource(videoResourceId)
        val bufferSize = 1024
        val buffer = ByteArray(bufferSize)
        val videoChunks = mutableListOf<ByteArray>()
        var bytesRead: Int
        try {
            while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                videoChunks.add(buffer.copyOf(bytesRead))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            inputStream.close()
        }
        return videoChunks
    }

    private fun generateCommentsForVideo(videoId: Int): List<Comment> {
        val comments = mutableListOf<Comment>()
        for(i in 0 until 5) {
            val comment = Comment(
                id = i,
                videoId = videoId,
                commentText = "Comment $i for video $videoId",
                userId = i,
                timeStamp = System.currentTimeMillis()
            )
            comments.add(comment)
        }
        return comments
    }
    private fun List<Comment>.toJson(): String {
        return Gson().toJson(this)
    }

    private fun Bitmap.toByteArray(): ByteArray {
        val stream = ByteArrayOutputStream()
        this.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }
}