package com.lenibonje.mycompose

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.lenibonje.mycompose.screens.main.MainScreen
import com.lenibonje.mycompose.service.StopwatchService
import com.lenibonje.mycompose.ui.theme.MyComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {

    private var isBound by mutableStateOf(false)
    private lateinit var stopwatchService: StopwatchService

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as StopwatchService.StopwatchBinder
            stopwatchService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            isBound = false
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this, StopwatchService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
//                navController = rememberNavController()
//                SetUpNavGraph(navController = navController)
                if (isBound) {
                    MainScreen(stopwatchService = stopwatchService)
                }
            }
        }
        requestPermissions(android.Manifest.permission.POST_NOTIFICATIONS)
    }

    private fun requestPermissions(vararg permissions: String) {
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { result ->
            result.entries.forEach {
                Log.d("MainActivity", "${it.key} = ${it.value}")
            }
        }
        requestPermissionLauncher.launch(permissions.asList().toTypedArray())
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        isBound = false
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var text by remember { mutableStateOf("") }

        TextField(
            value = text, onValueChange = { newtext -> text = newtext },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "")
                }
            },
            label = {
                Text(text = "Type here")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Go

            ),
            keyboardActions = KeyboardActions(
                onSearch = {}
            )

        )

        OutlinedTextField(
            value = text, onValueChange = { newtext -> text = newtext },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "")
                }
            },
            label = {
                Text(text = "Type here")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Go

            ),
            keyboardActions = KeyboardActions(
                onSearch = {}
            )
        )
    }
}

@Composable
fun CustomText() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
            .width(200.dp),
        color = MaterialTheme.colorScheme.surface,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End,

        )
}

@Composable
fun CustomTextB() {
    Text(
        buildAnnotatedString {
            withStyle(ParagraphStyle(textAlign = TextAlign.Center)) {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) { append("A") }

                append("B")
                append("C")
                append("D")
                append("E")
            }
        }, modifier = Modifier.width(200.dp)
    )
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CustomTextC() {
    Text(
        text = "Hello Word".repeat(20),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun CustomTextD() {
    Column {
        SelectionContainer {
            Text(
                text = "Hello Word"
            )
            DisableSelection {
                Text(
                    text = "Hello Word"
                )
            }

            Text(
                text = "Hello Word"
            )
        }
    }

}

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
//                    GrayscaleTransformation(),
//                    CircleCropTransformation(),
//                    BlurTransformation(LocalContext.current),
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

    @Composable
    fun SuperScriptText(
        normalText: String,
        superText: String

    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                    )
                ) {
                    append(normalText)
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        fontWeight = FontWeight.Normal,
                        baselineShift = BaselineShift.Subscript,

                        )
                ) {
                    append(superText)
                }
            }
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeTheme {
        CoilImage()
    }
}