package com.lenibonje.mycompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lenibonje.mycompose.screens.HomeScreen
import com.lenibonje.mycompose.screens.WelcomeScreen

@Composable
fun SetUpNavGraph(
    navController: androidx.navigation.NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }


    }
}