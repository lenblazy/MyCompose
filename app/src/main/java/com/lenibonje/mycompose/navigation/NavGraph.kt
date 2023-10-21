package com.lenibonje.mycompose.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.lenibonje.mycompose.Person
import com.lenibonje.mycompose.screens.DetailScreen
import com.lenibonje.mycompose.screens.DetailScreenB
import com.lenibonje.mycompose.screens.HomeScreen
import com.lenibonje.mycompose.screens.LoginScreen
import com.lenibonje.mycompose.screens.SharedViewModel
import com.lenibonje.mycompose.screens.SignUpScreen

@Composable
fun SetUpNavGraph(
    navController: androidx.navigation.NavHostController
) {

    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        route = ROOT_ROUTE
    ) {
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