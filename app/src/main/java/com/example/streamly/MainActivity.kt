package com.example.streamly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import com.example.streamly.navigation.NavCompose
import com.example.streamly.repository.VideoRepository
import com.example.streamly.supabase.api.VideoFetchService
import com.example.streamly.ui.theme.Black100
import com.example.streamly.viewmodels.VideoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Black100.toArgb()
        setContent {

            val videoFetchService  = VideoFetchService()
            val videoRepository = VideoRepository(videoFetchService)
            val videoViewModel = VideoViewModel(videoRepository)
            NavCompose(videoViewModel)
        }
    }
}
