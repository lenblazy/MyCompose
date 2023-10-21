package com.lenibonje.mycompose.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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

        composable(Screen.DetailB.route) {
            LaunchedEffect(key1 = it, block = {
                val result =
                    navController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")
                Log.d("Detail", "SetUpNavGraph: first name: ${result?.firstName} last name: ${result?.lastName}")
            })
            DetailScreenB(navController)
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