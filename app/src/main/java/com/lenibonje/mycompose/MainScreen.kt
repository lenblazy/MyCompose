package com.lenibonje.mycompose

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(mainViewModel: MainViewModel) {

    val searchWidgetState by mainViewModel.searchWidgetState
    val searchTextState by mainViewModel.searchTextState

    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = {
                    mainViewModel.updateSearchTextState(it)
                },
                onCloseClicked = {
                    mainViewModel.updateSearchTextState("")
                    mainViewModel.updateSearchWidgetState(SearchWidgetState.CLOSED)
                },
                onSearchClicked = {
                    Log.d("MainScreen", "MainScreen: onSearchClicked: $it")
                },
                onSearchTriggered = {
                    mainViewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
                }
            )
        }
    ) {}

}

@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit
) {
    Log.d("MainScreen", "MainAppBar: searchWidgetState: $searchWidgetState")
    when (searchWidgetState) {
        SearchWidgetState.OPENED -> SearchAppBar(
            text = searchTextState,
            onTextChange = onTextChange,
            onCloseClick = onCloseClicked,
            onSearchClick = onSearchClicked
        )
        SearchWidgetState.CLOSED -> DefaultAppBar(onSearchClicked = onSearchTriggered)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClick: () -> Unit,
    onSearchClick: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colorScheme.primary
    ) {
        TextField(
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Search here...",
                    color = Color.White,
                )
            },
            textStyle = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = { },
                    modifier = Modifier.alpha(ContentAlpha.medium)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()) onTextChange("")
                        else onCloseClick()
                    },
                    modifier = Modifier.alpha(ContentAlpha.medium)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Clear",
                        tint = Color.White
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { onSearchClick(text) }
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.White.copy(ContentAlpha.medium),
                containerColor = Color.Transparent,
            ),
        )
    }
}


@Composable
fun DefaultAppBar(onSearchClicked: () -> Unit) {
    TopAppBar(title = { Text(text = "Home", color = Color.White) },
        backgroundColor = MaterialTheme.colorScheme.primary,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        })
}

@Preview
@Composable
fun DefaultAppBarPreview() {
    DefaultAppBar {

    }
}

@Preview
@Composable
fun SearchAppBarPreview() {
    SearchAppBar(
        text = "Some random text",
        onTextChange = {},
        onCloseClick = {},
        onSearchClick = {}
    )
}
    


