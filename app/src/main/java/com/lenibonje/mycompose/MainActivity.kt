package com.lenibonje.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lenibonje.mycompose.navigation.SetUpNavGraph
import com.lenibonje.mycompose.screens.main.MainScreen
import com.lenibonje.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
//                navController = rememberNavController()
//                SetUpNavGraph(navController = navController)
                MainScreen()
            }
        }
    }
}

@Composable
fun Greeting() {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeTheme {
        Greeting()
    }
}