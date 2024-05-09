package com.example.streamly.repository

import com.example.streamly.data.Videos
import com.example.streamly.supabase.api.VideoFetchService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class VideoRepository (private val videoFetchService : VideoFetchService) {
    private val _dataState = MutableStateFlow<List<Videos>>(emptyList())
    val dataState: StateFlow<List<Videos>> = _dataState

    suspend fun fetchVideo(){
        val videos = videoFetchService.fetchVideos()
        _dataState.value = videos
    }
}