package com.lenibonje.mycompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    Image(
        contentScale = ContentScale.Fit,
        painter = painterResource(id = R.drawable.img),
        contentDescription = null,
        modifier = Modifier
            .size(300.dp)
            .clip(CircleShape)
            .border(width = 10.dp, color = Color.Blue, shape = CircleShape)
    )
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}