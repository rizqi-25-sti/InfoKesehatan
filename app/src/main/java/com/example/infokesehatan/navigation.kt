package com.example.infokesehatan

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*


@Composable
fun Navigation() {
    // Implement your navigation logic here
    val navController = rememberNavController()
    NavHost (
        navController = navController,
        startDestination = "homescreen"
    ) {
        composable("homescreen") { MyHealthApp(navController) }
        composable("profilescreen") { ProfileScreen(navController) }
        // Add more destinations as needed
    }

    // You can use libraries like Jetpack Navigation Compose for handling navigation
}