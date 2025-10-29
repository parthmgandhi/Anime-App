package com.example.animeapp.Pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.animeapp.Bars.BottomBar
import com.example.animeapp.ui.theme.AnimeAppTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentBackStackEntry = navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            val currentRoute = currentBackStackEntry.value?.destination?.route
            if (currentRoute != "infoPage") {
                BottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable("home") { HomePage() }
            composable("discussion") { DiscussionPage() }
            composable("discover") { DiscoverPage(navController) }
            composable("mylist") { MyList(navController) }
            composable("infoPage") { AnimeInfoPage(navController) }
        }
    }
}

