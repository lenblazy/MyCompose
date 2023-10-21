package com.lenibonje.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.lenibonje.mycompose.navigation.SetUpNavGraph
import com.lenibonje.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                val window = rememberWindowSize()
                val navController = rememberNavController()
                SetUpNavGraph(windowSize= window, navController = navController)
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