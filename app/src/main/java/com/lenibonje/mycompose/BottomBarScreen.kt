package com.lenibonje.mycompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object Home: BottomBarScreen(
        route = "home",
        icon = Icons.Default.Home,
        title = "Home"
    )
    object Profile: BottomBarScreen(
        route = "profile",
        icon = Icons.Default.Person,
        title = "Profile"
    )
    object Settings: BottomBarScreen(
        route = "settings",
        icon = Icons.Default.Settings,
        title = "Settings"
    )
}
