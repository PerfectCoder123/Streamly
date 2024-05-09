package com.example.streamly.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.streamly.components.splashscreen.AnimatedSplashScreen
import com.example.streamly.components.home.HomeScreen
import com.example.streamly.components.videoscreen.VideoScreen
import com.example.streamly.viewmodels.VideoViewModel

@Composable
fun NavCompose(videoViewModel: VideoViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SplashScreen.name ){
        composable(Routes.SplashScreen.name){
            AnimatedSplashScreen(navController = navController)
        }
        composable(Routes.HomeScreen.name){
            HomeScreen(navController = navController, videoViewModel = videoViewModel)
        }
        composable(Routes.VideoScreen.name){
            VideoScreen(navController = navController, videoViewModel = videoViewModel)
        }
    }

}