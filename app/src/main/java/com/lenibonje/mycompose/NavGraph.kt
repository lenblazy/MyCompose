package com.lenibonje.mycompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetUpNavGraph(
    navController: androidx.navigation.NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(name = DETAIL_ARG_KEY) {
                type = NavType.IntType
            })
        ) {
            DetailScreen(navController)
        }
    }
}