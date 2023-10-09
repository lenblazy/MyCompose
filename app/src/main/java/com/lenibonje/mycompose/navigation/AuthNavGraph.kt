package com.lenibonje.mycompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.lenibonje.mycompose.screens.LoginScreen
import com.lenibonje.mycompose.screens.SignUpScreen


fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Login.route,
        route = AUTH_ROUTE
    ) {
        composable(Screen.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
    }
}
