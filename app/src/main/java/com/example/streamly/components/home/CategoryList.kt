package com.example.streamly.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.streamly.ui.theme.Black10
import com.example.streamly.ui.theme.Black80


@Composable
fun CategoryList(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .horizontalScroll(rememberScrollState())
    ){
        CategoryCompose(text = "All", isActive = true)
        CategoryCompose(text = "game", isActive = false)
        CategoryCompose(text = "Ui", isActive = false)
        CategoryCompose(text = "Figma", isActive = false)
        CategoryCompose(text = "Ui design", isActive = false)
        CategoryCompose(text = "Ux design", isActive = false)
    }
}

@Composable
fun CategoryCompose(modifier: Modifier = Modifier, text : String, isActive : Boolean) {
    Text(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .clip(RoundedCornerShape((20.dp)))
            .background(if (isActive) Black80 else Color.Transparent)
            .padding(15.dp, 3.dp),
        text = text,
        style = TextStyle(
            color = Black10,
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold
        )
    )
}
