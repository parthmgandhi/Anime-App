package com.example.animeapp.Pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animeapp.AnimeRelated.AnimePost
import com.example.animeapp.Data.AnimePosterListJA
import com.example.animeapp.Bars.TopBar
import com.example.animeapp.Data.AnimePosterListNW
import com.example.animeapp.Data.AnimePosterListT
import com.example.animeapp.Data.AnimeData
import com.example.animeapp.Bars.SearchBar

@Composable
fun DiscoverPage(navController: NavController){
    var searchDiscover by remember { mutableStateOf("") }

    Scaffold(
        topBar = { Column {
            TopBar()
            SearchBar(
                searchText = searchDiscover,
                onTextChange = {searchDiscover = it}
            )
        } }
    ) { innerPadding ->
        EveryCategory(innerPadding, navController)
    }
}

@Composable
fun EveryCategory(
    innerPaddingValues: PaddingValues,
    navController: NavController,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier.padding(innerPaddingValues)
    ) {
        item {
            WithTitle(
                title = "Now Watching"
            ) {
                Layout(data = AnimePosterListNW,navController)
            }
        }
        item {
            WithTitle(
                title = "Just Added"
            ) {
                Layout(data = AnimePosterListJA,navController)
            }
        }
        item {
            WithTitle(
                title = "Trending"
            ) {
                Layout(data = AnimePosterListT,navController)
            }
        }
    }
}

@Composable
fun WithTitle(
    modifier: Modifier = Modifier,
    title: String,
    content: @Composable () -> Unit
){
    Column(modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        content()
    }
}

@Composable
fun Layout(
    data: List<AnimeData>,
    navController: NavController,
    modifier: Modifier = Modifier
){
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items( items=data){item ->
            AnimePost(item.Drawable, item.Text,item.Description,item.Rating,item.Rank,item.Popularity, type = 0, navController)
        }
    }
}


