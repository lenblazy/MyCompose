package com.lenibonje.mycompose.navigation


sealed class Screen(val route: String) {

    object Home: Screen(route = "home_screen")
    object Splash: Screen(route = "splash_screen")

}