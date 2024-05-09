package com.example.streamly.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.streamly.R
import com.example.streamly.ui.theme.leagueGothic


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

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
            ){
                Image(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "notification"
                )
                Box(
                    modifier = Modifier
                        .size(9.dp)
                        .clip(CircleShape)
                        .background(Color.Green)

                )
            }
            Image(
                modifier = Modifier
                    .padding(20.dp, 0.dp)
                    .size(32.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.img),
                contentDescription = "user"
            )
        }
    }
}
