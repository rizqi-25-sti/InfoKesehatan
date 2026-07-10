package com.example.infokesehatan

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "homescreen"
    ) {
        composable("homescreen") { 
            MyHealthApp(navController) 
        }
        composable("profilescreen") { 
            ProfileScreen(navController) 
        }
    }
}