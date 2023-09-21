package com.lenibonje.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
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
                    CoilImage()
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ) {

        val painter = rememberImagePainter(
            data = "https://avatars.githubuserconsent.com/u/14994036?v=4",
            builder = {
                placeholder(R.drawable.ic_launcher_foreground)
                error(R.drawable.ic_launcher_foreground)
                crossfade(1000)
                transformations(
                    GrayscaleTransformation(),
//                    CircleCropTransformation(),
                    BlurTransformation(LocalContext.current),
                    RoundedCornersTransformation(50f)
                )
            }

        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Logo Image")
//        if (painterState is ImagePainter.State.Loading){
//            CircularProgressIndicator()
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeTheme {
        CoilImage()
    }
}