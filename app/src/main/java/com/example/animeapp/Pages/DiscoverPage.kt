package com.example.animeapp.Pages

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animeapp.AnimeRelated.AnimePost
import com.example.animeapp.Data.AnimePosterListJA
import com.example.animeapp.Bars.TopBar
import com.example.animeapp.Data.AnimePosterListNW
import com.example.animeapp.Data.AnimePosterListT
import com.example.animeapp.Data.AnimeData
import com.example.animeapp.Bars.SearchBar
import com.example.animeapp.Data.AllAnimeList


@Composable
fun DiscoverPage(navController: NavController){
    var searchDiscover by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = { Column {
            TopBar()
            SearchBar(
                searchText = searchDiscover,
                onTextChange = {searchDiscover = it}
            )
        } }
    ) { innerPadding ->
        AnimatedContent(targetState = searchDiscover.isNotBlank()) { isSearching ->
            if (isSearching) {
                AfterSearchLayout(innerPadding,navController, query = searchDiscover)
            } else {
                EveryCategory(innerPadding, navController)
            }
        }

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


@Composable
fun AfterSearchLayout(
    innerPaddingValues: PaddingValues,
    navController: NavController,
    query: String,
    modifier: Modifier = Modifier
){

    val context = LocalContext.current

    var filteredList by rememberSaveable { mutableStateOf(AllAnimeList) }

    LaunchedEffect(query) {
        filteredList = if (query.isBlank()) {
            AllAnimeList
        } else {
            AllAnimeList.filter {
                val title = context.getString(it.Text)
                title.contains(query, ignoreCase = true)
            }
        }
    }

    LazyColumn(
        modifier.padding(innerPaddingValues)
    ) {
        items(filteredList){ item ->
            AfterSearch(item.Drawable,item.Text,item.Description,item.Rating,item.Rank,item.Popularity,navController)
        }
    }
}

@Composable
fun AfterSearch(
    drawable: Int,
    text: Int,
    description: Int,
    rating: Double,
    rank: Double,
    popularity: Double,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val anime = AnimeData(drawable, text, description, rating, rank, popularity)

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .clickable{
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("animeData", anime)

                    navController.navigate("infoPage")
                }
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                modifier = modifier
                    .size(
                        height = 120.dp,
                        width = 89.dp
                    ),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(text),
                modifier = modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

        }
        HorizontalDivider(
            color = Color.Gray,
            thickness = 1.dp,
        )

    }
}
