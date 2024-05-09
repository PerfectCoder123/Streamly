package com.example.streamly.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.streamly.R
import com.example.streamly.data.Videos
import com.example.streamly.ui.theme.Black10
import com.example.streamly.ui.theme.Black80
import com.example.streamly.utility.getTimeDifference


@Composable
fun VideoImage(video: Videos, onVideoClick : () -> Unit) {

    Column (
        modifier = Modifier
            .clickable {
                onVideoClick()
            }
    ){
        Box(modifier = Modifier ){
            AsyncImage(
                modifier = Modifier
                    .padding(10.dp)
                    .aspectRatio(1.5f)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(video.videoThumbnail)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = R.drawable.blog),
                contentDescription = "videos"
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Black80)
                    .align(Alignment.BottomEnd)

            ){
                Image(
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.play),
                    contentDescription = "play"
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(video.channelPhoto)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.img),
                contentDescription = "channel image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
            ){
                Text(
                    text = video.videoTitle,
                    style = TextStyle(
                        color = Black10,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ){
                    Text(
                        text = "${video.channelName} .",
                        style = TextStyle(
                            color = Black10,
                            fontSize = 12.sp
                        )
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text =  "${video.views} views",
                        style = TextStyle(
                            color = Black10,
                            fontSize = 12.sp
                        )
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = ". ${video.uploadTime?.let { getTimeDifference(it) }}",
                        style = TextStyle(
                            color = Black10,
                            fontSize = 12.sp
                        )
                    )
                }
            }
            Image(
                modifier = Modifier
                    .size(28.dp),
                painter = painterResource(id = R.drawable.setting),
                contentDescription = "settings"
            )
        }
    }
}
