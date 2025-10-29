package com.example.animeapp.Data

import androidx.navigation.NavController

fun CategoryButtonLogic(
    animeData: AnimeData,
    targetList: MutableList<AnimeData>,
    navController: NavController
) {
    CompletedList.removeAll{it.Drawable == animeData.Drawable}
    OnHoldList.removeAll{it.Drawable == animeData.Drawable}
    NowWatchingList.removeAll{it.Drawable == animeData.Drawable}

    if(animeData !in targetList) {
        targetList.add(animeData)
    }

    navController.navigateUp()
}