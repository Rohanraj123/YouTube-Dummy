package com.example.youtubedemo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.youtubedemo.data.model.Video
import com.example.youtubedemo.data.repository.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.SupabaseClient
import javax.inject.Inject

@HiltViewModel
class SupaBaseViewModel @Inject constructor(
    private val supabaseClient: SupabaseClient,
    private val videoRepository: VideoRepository
): ViewModel() {

    fun insertVideo(video: Video) {

    }
}