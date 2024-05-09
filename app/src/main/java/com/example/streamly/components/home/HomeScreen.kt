package com.example.streamly.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.streamly.R
import com.example.streamly.navigation.Routes
import com.example.streamly.ui.theme.Black100
import com.example.streamly.viewmodels.VideoViewModel

@Composable
fun HomeScreen(navController: NavHostController, videoViewModel: VideoViewModel) {
    val videoState by videoViewModel.videos.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Black100)
            .padding(horizontal = 8.dp),
    ){
        item {
            AppLogo()
            SearchBar(videoViewModel = videoViewModel)
            UserChannel()
            CategoryList()
        }
        if(videoState.isEmpty()){
            item {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 100.dp),
                    painter = painterResource(id = R.drawable.not_found),
                    contentDescription = "not found"
                )
            }
        }
        else {
            items(videoState.size) { index ->
            val video = videoState[index]
            VideoImage(video = video) {
                 videoViewModel.setCurrentVideo(video)
                navController.navigate(Routes.VideoScreen.name)
            }
        }
    }
    }
}
