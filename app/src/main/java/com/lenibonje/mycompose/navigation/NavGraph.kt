package com.lenibonje.mycompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.lenibonje.mycompose.screens.DetailScreen
import com.lenibonje.mycompose.screens.HomeScreen
import com.lenibonje.mycompose.screens.LoginScreen
import com.lenibonje.mycompose.screens.SignUpScreen

@Composable
fun SetUpNavGraph(
    navController: androidx.navigation.NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        route = ROOT_ROUTE
    ) {
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

        authNavGraph(navController = navController)

    }
}