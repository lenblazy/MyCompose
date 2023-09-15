package com.lenibonje.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lenibonje.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Surface(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                color = MaterialTheme.colorScheme.primary
            ) { }
            Surface(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                color = MaterialTheme.colorScheme.primary
            ) { }
            Surface(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                color = MaterialTheme.colorScheme.primary
            ) { }
            Surface(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                color = MaterialTheme.colorScheme.primary
            ) { }
        }
    }
}