package com.lenibonje.mycompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lenibonje.mycompose.Person
import com.lenibonje.mycompose.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                val person = Person(
                    firstName = "John",
                    lastName = "Doe"
                )

                sharedViewModel.addPerson(person)
                navController.navigate(Screen.DetailB.route)
            },
        contentAlignment = Center

    ) {
        Text(
//            modifier = Modifier.clickable {
//                navController.navigate(Screen.Detail.passId(5))
//            },
            text = "Home Screen",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController(), viewModel())
}

