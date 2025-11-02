package com.example.animeapp.Pages

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animeapp.AnimeRelated.ProfilePic
import com.example.animeapp.Bars.SearchBar
import com.example.animeapp.Bars.TopBar
import com.example.animeapp.Data.DiscussionData
import com.example.animeapp.Data.discussionDataList

@Composable
fun DiscussionPage(){
    var searchDiscussion by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            Column {
                TopBar()
                SearchBar(
                    searchText = searchDiscussion,
                    onTextChange = {searchDiscussion = it}
                )
            } },

    ) { innerPadding ->
        DiscussionPageWithData(innerPadding, discussionDataList, searchDiscussion)
    }
}

@Composable
fun DiscussionPageWithData(
    innerPaddingValues: PaddingValues,
    data: List<DiscussionData>,
    query: String,
    modifier: Modifier = Modifier
){
    var filteredList by rememberSaveable { mutableStateOf(data) }

    LaunchedEffect(query) {
        filteredList = if(query.isBlank()){
            data
        } else {
            data.filter {
                it.accName.contains(query, ignoreCase = true)
            }
        }
    }

    LazyColumn(
        modifier.padding(innerPaddingValues)
    ) {
        items(items = filteredList){ item ->
            AccDiscussion(
                drawable = item.profile,
                accName = item.accName,
                text = item.text
            )
        }
    }
}

@Composable
fun AccDiscussion(
    @DrawableRes drawable: Int,
    accName: String,
    text: String,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier
    ) {
        Column {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .padding(vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                ProfilePic(65.dp, drawable)
                Column(
                    modifier = modifier
                ) {
                    Text(
                        text = accName,
                        fontWeight = FontWeight.W700,
                        style = MaterialTheme.typography.titleMedium,
                        lineHeight = 20.sp
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.W500,
                        lineHeight = 17.sp,
                        modifier = modifier.padding(vertical = 3.dp)
                    )
                }
            }
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
            )
        }
    }
}



