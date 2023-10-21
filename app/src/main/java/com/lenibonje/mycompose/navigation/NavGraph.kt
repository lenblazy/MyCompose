package com.lenibonje.mycompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.lenibonje.mycompose.WindowSize
import com.lenibonje.mycompose.screens.DetailScreen
import com.lenibonje.mycompose.screens.DetailScreenB
import com.lenibonje.mycompose.screens.HomeScreen
import com.lenibonje.mycompose.screens.SharedViewModel
import com.lenibonje.mycompose.screens.main.MainScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    windowSize: WindowSize
) {

    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
        route = ROOT_ROUTE
    ) {

        composable(Screen.Main.route) {
            MainScreen(windowSize = windowSize, navController = navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController, sharedViewModel)
        }

        composable(Screen.DetailB.route) {
            DetailScreenB(navController, sharedViewModel)
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