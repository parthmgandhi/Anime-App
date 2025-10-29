package com.example.animeapp.Data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimeData(
    @DrawableRes val Drawable: Int,
    @StringRes val Text: Int,
    @StringRes val Description: Int,
    val Rating: Double,
    val Rank: Double,
    val Popularity: Double
): Parcelable
