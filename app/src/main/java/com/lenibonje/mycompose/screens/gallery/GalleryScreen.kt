package com.lenibonje.mycompose.screens.gallery

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun GalleryScreen() {
    val images = remember {
        mutableStateListOf(
            "https://picsum.photos/800",
            "https://picsum.photos/id/237/800",
            "https://picsum.photos/seed/picsum/800",
            "https://picsum.photos/800?grayscale"
        )
    }

    val pagerState = rememberPagerState { images.size }

    val matrix = remember {
        ColorMatrix()
    }

    Scaffold(modifier = Modifier.padding(vertical = 48.dp)) {
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill,
            pageContent = { index ->

                val pageOffSet =
                    (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
                val imageSize by animateFloatAsState(
                    targetValue = if (pageOffSet != 0.0f) 0.75f else 1f,
                    animationSpec = tween(300), label = ""
                )

                LaunchedEffect(key1 = imageSize){
                    if (pageOffSet != 0.0f){
                        matrix.setToSaturation(0f)
                    }else{
                        matrix.setToSaturation(1f)
                    }
                }

                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 16.dp)
                        .graphicsLayer { scaleX = imageSize; scaleY = imageSize }
                        .clip(RoundedCornerShape(16.dp)),
                    model = ImageRequest.Builder(LocalContext.current).data(images[index]).build(),
                    contentDescription = "Simple image",
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.colorMatrix(matrix)
                )
            }
        )
    }
}
