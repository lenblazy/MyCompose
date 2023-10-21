package com.lenibonje.mycompose.screens.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lenibonje.mycompose.WindowSize
import com.lenibonje.mycompose.WindowType

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel(),
    windowSize: WindowSize,
    navController: NavHostController
) {
    val items = mainViewModel.items

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = items) {
//            CustomCard(data = it)
            AdaptableItem(data = it, windowSize = windowSize)
        }
    }

}

@Composable
fun AdaptableItem(data: CustomData, windowSize: WindowSize) {
    val maxLines by remember(key1 = windowSize) {
        mutableStateOf(if (windowSize.width == WindowType.Compact) 4 else 10)
    }

    when (windowSize.height) {
        WindowType.Expanded -> {
            Column {
                ColumnContent(
                    data = data,
                    windowSize = windowSize,
                    maxLines = maxLines
                )
            }
        }
        else -> {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                RowContent(
                    data = data,
                    windowSize = windowSize,
                    maxLines = maxLines
                )
            }
        }
    }
}

@Composable
fun RowScope.RowContent(
    data: CustomData,
    windowSize: WindowSize,
    maxLines: Int
) {
    val showIcons by remember(key1 = windowSize) {
        mutableStateOf(windowSize.width == WindowType.Expanded)
    }

    AsyncImage(
        modifier = Modifier
            .weight(1f),
        model = ImageRequest.Builder(LocalContext.current)
            .data(data = data.image)
            .crossfade(enable = true)
            .build(),
        contentDescription = "Image",
        contentScale = ContentScale.Crop
    )

    Column(modifier = Modifier.weight(1f)) {
        Text(
            text = data.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.width) {
                    WindowType.Expanded -> MaterialTheme.typography.labelLarge.fontSize
                    WindowType.Medium -> MaterialTheme.typography.labelMedium.fontSize
                    else -> MaterialTheme.typography.titleLarge.fontSize
                },
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier.alpha(0.5f),
            text = data.description,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.width) {
                    WindowType.Expanded -> MaterialTheme.typography.labelLarge.fontSize
                    WindowType.Medium -> MaterialTheme.typography.labelMedium.fontSize
                    else -> MaterialTheme.typography.bodyMedium.fontSize
                }
            )
        )
        if (showIcons) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                data.badges.forEach {
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = it,
                        contentDescription = "Icon"
                    )
                }
            }
        }
    }
}

@Composable
fun ColumnContent(
    data: CustomData,
    windowSize: WindowSize,
    maxLines: Int
) {
    val showIcons by remember(key1 = windowSize) {
        mutableStateOf(windowSize.height == WindowType.Expanded)
    }

    AsyncImage(
        modifier = Modifier.fillMaxWidth().height(400.dp),
        model = ImageRequest.Builder(LocalContext.current)
            .data(data = data.image)
            .crossfade(enable = true)
            .build(),
        contentDescription = "Image",
        contentScale = ContentScale.Crop
    )

    Column {
        Text(
            text = data.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.height) {
                    WindowType.Expanded -> MaterialTheme.typography.headlineSmall.fontSize
                    else -> MaterialTheme.typography.headlineLarge.fontSize
                },
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier.alpha(0.5f),
            text = data.description,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.height) {
                    WindowType.Expanded -> MaterialTheme.typography.headlineSmall.fontSize
                    else -> MaterialTheme.typography.bodyMedium.fontSize
                }
            )
        )
        if (showIcons) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                data.badges.forEach {
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = it,
                        contentDescription = "Icon"
                    )
                }
            }
        }
    }
}

@Composable
fun CustomCard(data: CustomData) {
    Row(modifier = Modifier.border(width = 1.dp, color = Color.LightGray)) {
        AsyncImage(
            modifier = Modifier
                .weight(1f),
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = data.image)
                .crossfade(true)
                .build(),
            contentDescription = "Card Image",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        BoxWithConstraints(
            modifier = Modifier
                .weight(1.5f)
                .padding(vertical = 12.dp)
        ) {
            AdaptiveContent(data = data)
        }
    }
}

@Composable
fun BoxWithConstraintsScope.AdaptiveContent(data: CustomData) {
    val badgeSize = 24.dp
    val padding = 24.dp
    val numberOfBadgesToShow = maxWidth.div(badgeSize + padding).toInt().minus(1)
    val remainingBadges = data.badges.size - numberOfBadgesToShow

    Log.d("HomeScreen", "${this.maxWidth}")
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = data.title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = data.description,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            maxLines = if (this@AdaptiveContent.maxWidth > 250.dp) 10 else 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(space = padding)) {
            data.badges.take(numberOfBadgesToShow).forEach {
                Icon(
                    modifier = Modifier.size(badgeSize),
                    tint = MaterialTheme.colorScheme.primary,
                    imageVector = it,
                    contentDescription = "Badge Icon"
                )
            }
            if (remainingBadges > 0) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.LightGray)
                        .padding(6.dp)
                ) {
                    Text(
                        text = "+$remainingBadges",
                        style = TextStyle(fontSize = MaterialTheme.typography.labelMedium.fontSize)
                    )
                }
            }
        }
    }
}