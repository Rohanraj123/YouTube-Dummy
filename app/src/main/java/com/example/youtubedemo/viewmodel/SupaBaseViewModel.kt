package com.example.youtubedemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubedemo.data.model.videos
import com.example.youtubedemo.data.repository.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.storage.storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

@HiltViewModel
class SupaBaseViewModel @Inject constructor(
    private val supabaseClient: SupabaseClient,
    private val videoRepository: VideoRepository
): ViewModel() {

    private val _videos = MutableStateFlow<List<videos>>(emptyList())
    val videos = _videos.asStateFlow()

    fun insertVideo(video: videos) {
        viewModelScope.launch {
            videoRepository.insertVideo(video)
            Log.d("ViewModel", "insertVideo of repo is called")
        }
    }

    fun getIds(): List<Int> {
        return listOf(1, 2, 3)
    }
    fun getTitles(): List<String> {
        return listOf("Scientific Video", "World Best Video", "Happy hours")
    }
    fun getLikes(): List<Int> {
        return listOf(12, 34, 46)
    }
    fun getViews(): List<Int> {
        return listOf(123, 123123, 12312321)
    }
    fun getDescriptions(): List<String> {
        return listOf(
            "This is the most beautiful scientific video",
            "This is the world best video and Here is this video",
            "Happy hours means a lot to the people's lives"
        )
    }

    fun getVideos() {
        viewModelScope.launch {
            _videos.value = videoRepository.getVideos()
        }
    }

}