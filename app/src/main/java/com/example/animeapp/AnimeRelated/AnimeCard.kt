package com.example.animeapp.AnimeRelated

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animeapp.Data.DrawableStringPair

@Composable
fun AnimePost(
    drawable: Int,
    text: Int,
    description: Int,
    rating: Double,
    rank: Double,
    popularity: Double,
    type: Int, //0 => column or row, 1 => grid
    navController: NavController,
    modifier: Modifier = Modifier
){
    val anime = DrawableStringPair(drawable, text, description, rating, rank, popularity)

    Column(
        modifier = modifier
            .width(width = if(type == 0) 135.dp else 185.dp)
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            modifier = modifier
                .size(
                    height = if(type == 0) 200.dp else 250.dp,
                    width = if(type == 0) 137.dp else 187.dp
                )
                .clickable{
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("animeData", anime)

                    navController.navigate("infoPage")
                },
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
        Text(
            text = stringResource(text),
            textAlign = TextAlign.Left,
            lineHeight = 18.sp
        )
    }
}