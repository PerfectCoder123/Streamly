package com.example.streamly.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.streamly.data.Videos
import com.example.streamly.repository.VideoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VideoViewModel(private val videoRepository: VideoRepository) : ViewModel() {

    val videoState: StateFlow<List<Videos>> = videoRepository.dataState

    private val _videos = MutableStateFlow<List<Videos>>(emptyList())
    val videos: StateFlow<List<Videos>> = _videos

    private val _currentVideo = MutableStateFlow<Videos?>(null)
    val currentVideo: StateFlow<Videos?> = _currentVideo

    init {
        fetchData()
    }

    fun searchVideo(search: String) {
        val filteredVideos = videoState.value.filter { video ->
            video.videoTitle.contains(search, ignoreCase = true) ||
                    video.channelName.contains(search, ignoreCase = true) ||
                    video.videoDescription?.contains(search, ignoreCase = true) ?: false
        }
        _videos.value = filteredVideos
    }

    fun setCurrentVideo(video: Videos) {
        _currentVideo.value = video
    }

    private fun fetchData() {
        viewModelScope.launch {
            videoRepository.fetchVideo()
            _videos.value = videoState.value
        }
    }
}

