package com.example.animeapp.Pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animeapp.AnimeRelated.AnimePost
import com.example.animeapp.Data.CompletedList
import com.example.animeapp.Data.AnimeData
import com.example.animeapp.Data.NowWatchingList
import com.example.animeapp.Data.OnHoldList
import com.example.animeapp.Bars.TopBar

@Composable
fun MyList(navController: NavController) {
    val tabs = listOf("Now Watching", "Completed", "On Hold")
    val data = listOf(NowWatchingList, CompletedList, OnHoldList)
    var selected by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        topBar = {
            Column {
                TopBar()
                SimpleTabRow(tabs = tabs, selectedIndex = selected, onTabSelected = {selected = it})
            }
        },

    ){  innerPadding ->
        DataFilled(innerPaddingValues = innerPadding, selected = selected, data = data, navController)
    }

}

@Composable
fun DataFilled(
    innerPaddingValues: PaddingValues,
    selected: Int,
    data: List<List<AnimeData>>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid (
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize().padding(innerPaddingValues),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(15.dp)
    ) {
        items(items = data.elementAt(selected)) { item ->
            AnimePost(item.Drawable, item.Text,item.Description,item.Rating,item.Rank,item.Popularity, type = 1, navController )
        }
    }
}


@Composable
fun SimpleTabRow(
    tabs: List<String>,
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    TabRow(
        selectedTabIndex = selectedIndex,
        modifier = modifier.fillMaxWidth(),
        contentColor = MaterialTheme.colorScheme.onSurface,
        indicator = { tabPositions ->
            // Underline indicator
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[selectedIndex]).height(3.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        text = title,
                        style = if (index == selectedIndex) MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
                        else MaterialTheme.typography.bodyMedium
                    )
                }
            )
        }
    }
}

