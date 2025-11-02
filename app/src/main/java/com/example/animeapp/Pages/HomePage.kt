package com.example.animeapp.Pages

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animeapp.AnimeRelated.ProfilePic
import com.example.animeapp.Bars.TopBar
import com.example.animeapp.Data.HomeData
import com.example.animeapp.Data.homeDataList

@Composable
fun HomePage(){
    Scaffold (
        topBar = { TopBar() }
    ){innerPadding ->
        AccPostWithData(innerPadding, homeDataList)
    }
}

@Composable
fun AccPostWithData(
    innerPaddingValues: PaddingValues,
    data: List<HomeData>,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier.padding(innerPaddingValues)
    ) {
        items(items = data){ item ->
            AccPost(
                drawable = item.profile,
                heading = item.headLine,
                text = item.text,
                post = item.post
            )
        }
    }
}

@Composable
fun AccPost(
    @DrawableRes drawable: Int,
    heading: String,
    text: String,
    @DrawableRes post: Int?,
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
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(11.dp)
            ) {
                ProfilePic(size = 70.dp, drawable = drawable)
                Column(
                    modifier = modifier
                ) {
                    Text(
                        text = heading,
                        fontWeight = FontWeight.W700,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.W500,
                        lineHeight = 17.sp,
                        modifier = modifier.padding(vertical = 3.dp)
                    )
                    if(post != null){
                        Image(
                            painter = painterResource(post),
                            contentDescription = null,
                            modifier = modifier
                                .padding(vertical = 5.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.FillHeight
                        )
                    }

                }
            }
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = modifier.padding(top = 5.dp)
            )
        }
    }
}
