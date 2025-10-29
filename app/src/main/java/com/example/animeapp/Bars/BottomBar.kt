package com.example.animeapp.Bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.FormatListBulleted
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(
    navController: NavController,
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color.LightGray,
        ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text("Home")
            },
            selected = currentRoute == "home",
            onClick = {navController.navigate("home"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.ChatBubbleOutline,
                    contentDescription = null
                )
            },
            label = {
                Text("Discussion")
            },
            selected = currentRoute == "discussion",
            onClick = {navController.navigate("discussion"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            label = {
                Text("Discover")
            },
            selected = currentRoute == "discover",
            onClick = {navController.navigate("discover"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.FormatListBulleted,
                    contentDescription = null
                )
            },
            label = {
                Text("My List")
            },
            selected = currentRoute == "mylist",
            onClick = {navController.navigate("mylist"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }}
        )
    }
}