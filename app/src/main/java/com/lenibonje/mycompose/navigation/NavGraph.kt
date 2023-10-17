package com.lenibonje.mycompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lenibonje.mycompose.screens.SearchScreen

@Composable
fun SetUpNavGraph(
    navController: androidx.navigation.NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(Screen.Home.route) {
//            HomeScreen(navController = navController)
        }


    }
}