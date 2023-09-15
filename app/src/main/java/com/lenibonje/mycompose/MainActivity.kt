package com.lenibonje.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeTheme {
        CustomTextD()
    }
}