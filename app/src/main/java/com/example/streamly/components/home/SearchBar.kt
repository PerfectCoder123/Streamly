package com.example.streamly.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.streamly.R
import com.example.streamly.ui.theme.Black30
import com.example.streamly.viewmodels.VideoViewModel


@Composable
fun SearchBar(modifier: Modifier = Modifier, videoViewModel: VideoViewModel) {
    var text by remember { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            modifier = Modifier
                .height(50.dp)
                .weight(1f),
            textStyle = TextStyle(Black30),
            value = text,
            onValueChange = { newText ->
                text = newText
                videoViewModel.searchVideo(text)
            },
            placeholder = {
                Text(
                    text = "Search videos",
                    style = TextStyle(fontSize = 14.sp)
                )
            },
            singleLine = true,
            leadingIcon = {
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search"
                )
            }
        )

        Image(
            modifier = Modifier
                .padding(10.dp, 0.dp, 0.dp, 0.dp)
                .size(32.dp),
            painter = painterResource(id = R.drawable.filter),
            contentDescription = "filter"
        )
    }
}

