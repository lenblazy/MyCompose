package com.lenibonje.mycompose.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lenibonje.mycompose.navigation.Screen

@Composable
fun DetailScreenB(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {

    val person = sharedViewModel.person
    LaunchedEffect(key1 = person){
        person?.let {
            Log.d("DetailsScreen", "DetailScreenB: ${person.firstName} ${person.lastName}")
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable { navController.navigate(route = Screen.Home.route){
                popUpTo(Screen.Home.route) {
                    inclusive = true
                }
            } },
            text = "Detail Screen",
            color = Color.Red,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenBPreview() {
    DetailScreenB(rememberNavController(), viewModel())
}