package com.example.streamly.components.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.streamly.R

@Composable
fun UserChannel(){
    val horizontalScroll = rememberScrollState()
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(horizontalScroll)
    ){
        ChannelCompose("https://assets-global.website-files.com/6320fabc41e0512485e11e03/6326c865e3580b7a1d07455c_kyle-loftus-592091-unsplash-1080x675.jpg")
        ChannelCompose("https://t4.ftcdn.net/jpg/01/90/21/87/360_F_190218739_vvloVIcoca1Jl6ymuY9RQL88O3gocngN.jpg")
        ChannelCompose("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9Zh0OlwcQIy2wNJQ4DnkuP8orF6MgUdXBl27nOQt1h1R-6_bqMBQiAw3NwRQfRqFv5ME&usqp=CAU")
        ChannelCompose("https://t3.ftcdn.net/jpg/02/38/53/12/360_F_238531262_JpRtcKZv6pb84bKmHTBKj9QMGXzQgVdp.jpg")
        ChannelCompose("https://politics.princeton.edu/sites/default/files/styles/square/public/images/p-5.jpeg?h=87dbaab7&itok=ub6jAL5Q")
        ChannelCompose("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0Pl6QAfcYbpXnK4ZpAzrocLEBkB3t14Su9qMugJqz6yX7PiEsc-w1G4g_m1eyvjNum5k&usqp=CAU")
    }
}

@Composable
fun ChannelCompose(url : String){
    AsyncImage(
        modifier = Modifier
            .padding(10.dp)
            .size(50.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(id = R.drawable.img),
        contentDescription = "channels"
    )
}
