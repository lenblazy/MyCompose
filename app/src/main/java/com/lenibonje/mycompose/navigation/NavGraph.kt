package com.lenibonje.mycompose.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lenibonje.mycompose.AnimatedSplashScreen
import com.lenibonje.mycompose.screens.HomeScreen
import com.lenibonje.mycompose.screens.SplashScreen

@Composable
fun SetUpNavGraph(
    navController: androidx.navigation.NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
    ) {
        composable(Screen.Splash.route) {
            AnimatedSplashScreen(navController = navController)
        }

        composable(Screen.Home.route) {
            Box(modifier = Modifier.fillMaxSize())
        }



    }
}