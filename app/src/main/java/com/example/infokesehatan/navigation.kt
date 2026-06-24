package com.example.infokesehatans

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.infokesehatan.MyHealthApp
import com.example.infokesehatan.ProfileScreen


@Composable
fun Navigation() {

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