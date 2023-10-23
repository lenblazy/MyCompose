package com.lenibonje.mycompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.text.TextStyle
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
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.lenibonje.mycompose.ui.theme.MyComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
//                navController = rememberNavController()
//                SetUpNavGraph(navController = navController)
                MyList()
            }
        }
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyList() {
    val lazyListState = rememberLazyListState()

    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            MainContent(lazyListState = lazyListState)
            TopBar(lazyListState = lazyListState)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(lazyListState: LazyListState) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .animateContentSize(animationSpec = tween(durationMillis = 300))
            .height(height = if (lazyListState.isScrolled) 0.dp else TOP_BAR_HEIGHT), title = {
            Text(
                text = "Title",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }
    )
}

@Composable
fun MainContent(lazyListState: LazyListState) {
    val numbers = remember { List(size = 25) { it } }
    val padding by animateDpAsState(
        targetValue = if (lazyListState.isScrolled) 0.dp else TOP_BAR_HEIGHT,
        animationSpec = tween(durationMillis = 300)
    )
    LazyColumn(
        modifier = Modifier.padding(top = padding),
        state = lazyListState
    ) {
        items(count = numbers.size) {
            NumberHolder(number = it)
        }

    }
}

@Composable
fun NumberHolder(number: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = number.toString(),
            style = TextStyle(
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = FontWeight.Bold
            )
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

val TOP_BAR_HEIGHT = 56.dp
val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0