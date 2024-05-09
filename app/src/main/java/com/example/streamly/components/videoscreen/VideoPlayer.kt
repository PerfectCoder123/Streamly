package com.example.streamly.components.videoscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView


@Composable
fun VideoPlayer(url: String) {
    val context = LocalContext.current
    var player = remember { ExoPlayer.Builder(context).build() }

    val mediaItem = remember { MediaItem.fromUri(url) }
    player.setMediaItem(mediaItem)
    player.playWhenReady = true
    player.prepare()

    Box(
        modifier = Modifier
            .background(Color.Black)
    ) {
        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player.let { exoPlayer ->
                        player = exoPlayer
                    }
                }
            },
            update = { view ->
                view.player = player
            },
        )

    }

    DisposableEffect(Unit) {
        onDispose {
            player.release()
        }
    }
}
