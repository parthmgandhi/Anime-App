package com.example.animeapp.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animeapp.Bars.BackTopBar
import com.example.animeapp.Data.AnimeData
import com.example.animeapp.Data.CategoryButtonLogic
import com.example.animeapp.Data.CompletedList
import com.example.animeapp.Data.NowWatchingList
import com.example.animeapp.Data.OnHoldList
import com.example.animeapp.Data.buttonEnable

@Composable
fun AnimeInfoPage(navController: NavController){
    val anime = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<AnimeData>("animeData")

    Scaffold(
        topBar = {BackTopBar(navController)}
    ) { innerPadding ->
        if(anime != null){
            AnimeInfo(innerPadding, anime, navController)
        } else {
            Text("No anime data found", modifier = Modifier.padding(16.dp))
        }

    }
}

@Composable
fun AnimeInfo(
    innerPaddingValues: PaddingValues,
    anime: AnimeData,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(innerPaddingValues)
    ) {
        Spacer(modifier = modifier.height(15.dp))
        UpperPart(anime)
        Spacer(modifier = modifier.height(15.dp))
        CategoryButton(anime,navController)
        Spacer(modifier = modifier.height(20.dp))
        Text(
            text = stringResource(anime.Text),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.W600,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(25.dp))
        Text(
            text = stringResource(anime.Description),
            fontWeight = FontWeight.W500,
            modifier = modifier.padding(horizontal = 15.dp),
            lineHeight = 18.sp,
            fontSize = 15.sp
        )
    }

}

@Composable
fun UpperPart(
    anime: AnimeData,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(anime.Drawable),
            contentDescription = null,
            modifier = modifier
                .size(
                    height =  300.dp,
                    width =  237.dp
                )
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            verticalArrangement = Arrangement.spacedBy(17.dp)
        ) {
            RatingData("Score:", anime.Rating)
            RatingData("Rank:",anime.Rank)
            RatingData("Popularity:", anime.Popularity)
        }
    }
}

@Composable
fun RatingData(
    heading: String,
    value: Double,
){
    Column {
        Text(
            text = heading,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = "$value"
        )
    }
}

@Composable
fun CategoryButton(
    anime: AnimeData,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(horizontal = 10.dp)
    ) {
        Button(
            onClick = {CategoryButtonLogic(
                anime,
                NowWatchingList,
                navController
            )},
            shape = MaterialTheme.shapes.extraSmall,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3F51B5),
                contentColor = Color.White
            ),
            enabled = buttonEnable(anime,NowWatchingList)
        ){
            Text(
                text = "Now watching",
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            onClick = {CategoryButtonLogic(
                anime,
                CompletedList,
                navController
            )},
            shape = MaterialTheme.shapes.extraSmall,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3F51B5),
                contentColor = Color.White
            ),
            enabled = buttonEnable(anime,CompletedList)
        ){
            Text(
                text = "Completed",
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            onClick = {CategoryButtonLogic(
                anime,
                OnHoldList,
                navController
            )},
            shape = MaterialTheme.shapes.extraSmall,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3F51B5),
                contentColor = Color.White
            ),
            enabled = buttonEnable(anime,OnHoldList)
        ){
            Text(
                text = "On Hold",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

