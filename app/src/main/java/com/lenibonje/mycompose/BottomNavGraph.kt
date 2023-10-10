package com.lenibonje.mycompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lenibonje.mycompose.screens.HomeScreen
import com.lenibonje.mycompose.screens.ProfileScreen
import com.lenibonje.mycompose.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(BottomBarScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(BottomBarScreen.Settings.route) {
            SettingsScreen(navController = navController)
        }

    }

}