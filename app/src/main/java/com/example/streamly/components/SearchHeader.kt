package com.example.streamly.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.streamly.R
import com.example.streamly.ui.theme.Black100
import com.example.streamly.ui.theme.Black30
import com.example.streamly.ui.theme.Black80
import com.example.streamly.ui.theme.leagueGothic

@Composable
fun SearchHeader(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black100)
            .padding(8.dp),
    ){
        AppLogo()
        SearchBar()
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(10.dp, 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Black80)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically

    ){
        Image(
            modifier = Modifier
                .size(20.dp),
            painter = painterResource(id = R.drawable.search),
            contentDescription = "search"
        )
        Text(
            modifier = modifier
                .padding(5.dp, 0.dp),
            style = TextStyle(
                color = Black30
            ),
            text = "search videos"
        )
    }
}
@Composable
fun AppLogo() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .padding(3.dp, 5.dp)
                    .size(32.dp),
                painter = painterResource(id = R.drawable.applogo),
                contentDescription = "app-logo"
            )
            Text(
                text = "Streamly",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = leagueGothic,
                    color = Color.White
                )
            )
        }

        Image(
            modifier = Modifier
                .size(40.dp)
                .padding(5.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.img),
            contentDescription = "user"
        )
    }
}