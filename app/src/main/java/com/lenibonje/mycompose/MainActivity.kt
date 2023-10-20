package com.lenibonje.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lenibonje.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {

                var selected by remember { mutableStateOf(false) }
                var selected2 by remember { mutableStateOf(false) }

                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    SelectableItem(
                        isSelected = selected, title = "I love android"
                    ) {
                        selected = !selected
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    SelectableItem(
                        isSelected = selected2,
                        title = "I love android",
                        subTitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                                "sed do eiusmod tempor incididunt ut labore et dolore magna" +
                                " aliqua.",
                    ) {
                        selected2 = !selected2
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .width(100.dp)
                .height(100.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "I love android", fontSize = 40.sp)
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeTheme {
        Greeting()
    }
}