package com.example.streamly.components.videoscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.streamly.R
import com.example.streamly.ui.theme.Black10
import com.example.streamly.ui.theme.Black100
import com.example.streamly.utility.formatDate
import com.example.streamly.utility.formatSubscriberCount
import com.example.streamly.utility.getTimeDifference
import com.example.streamly.viewmodels.VideoViewModel

@Composable
fun VideoScreen(navController: NavHostController, videoViewModel: VideoViewModel) {

    val video = videoViewModel.currentVideo.collectAsState()
    val url = video.value!!.videoUrl
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black100)
    ) {
        VideoPlayer(url = url)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),

            ){
            Text(
                modifier = Modifier,
                text = video.value!!.videoTitle,
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.White
                )
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
            ){
                Text(
                    text = "${video.value!!.views} views",
                    color = Black10,
                    style = TextStyle(
                        fontSize = 14.sp
                    )
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "${video.value!!.uploadTime?.let { getTimeDifference(it) }}",
                    color = Black10,
                    style = TextStyle(
                        fontSize = 14.sp
                    )
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "...more",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 14.sp
                    )
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                model = video.value!!.channelPhoto,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(32.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.img),
                contentDescription = "user image"
            )

            Text(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                text = video.value!!.channelName,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                )
            )

            Text(
                text = formatSubscriberCount(video.value!!.subscribers),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Black10
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .background(Color.White, CircleShape)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "subscribe",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Black100
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .padding(vertical = 5.dp),
                    text = "${video.value!!.videoLikes}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.dislike),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .padding(vertical = 5.dp),
                    text = "${video.value!!.videoDislikes}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.send),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .padding(vertical = 5.dp),
                    text = "send",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.bookmark),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .padding(vertical = 5.dp),
                    text = "save",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.downloads),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .padding(vertical = 5.dp),
                    text = "download",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }
        }
        Column {
            Text(
                modifier = Modifier
                    .padding(20.dp, 10.dp),
                text = "${video.value!!.uploadTime?.let { formatDate(it) }}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Black10
                )
            )
            Text(
                modifier = Modifier
                    .padding(20.dp, 10.dp),
                text = "${video.value!!.videoDescription}",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Black10
                )
            )
        }

    }
}


