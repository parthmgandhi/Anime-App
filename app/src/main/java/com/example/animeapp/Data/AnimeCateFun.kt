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

fun buttonEnable(
    animeData: AnimeData,
    targetList: MutableList<AnimeData>
): Boolean{
    return !targetList.any {it.Drawable == animeData.Drawable}
}