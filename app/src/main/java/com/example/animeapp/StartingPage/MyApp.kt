package com.example.animeapp.StartingPage

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animeapp.Pages.MainScreen

@Composable
fun MyApp(
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Sign In"
    ) {
        composable("Sign In") { LoginPage(navController) }
        composable("register") { RegisterPage(navController) }
        composable("MainScreen") { MainScreen() }
    }
}
