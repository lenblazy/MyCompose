package com.lenibonje.mycompose.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.lenibonje.mycompose.screens.home.HomeScreen
import com.lenibonje.mycompose.screens.search.SearchScreen

@OptIn(ExperimentalPagingApi::class, ExperimentalMaterial3Api::class, ExperimentalCoilApi::class)
@Composable
fun SetUpNavGraph(
    navController: androidx.navigation.NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Search.route){
            SearchScreen(navController = navController)
        }
    }
}