package com.example.animeapp.Data

import androidx.annotation.DrawableRes
import com.example.animeapp.R

data class HomeData(
    @DrawableRes val profile: Int,
    val headLine: String,
    val text: String,
    @DrawableRes val post: Int? = null
)

data class DiscussionData(
    @DrawableRes val profile: Int,
    val accName: String,
    val text: String
)

val homeDataList = mutableListOf(
    HomeData(profile = R.drawable.profile1, headLine = "Challenge Stacks" , text = "Last chance to get your profile badge for the killer Comedy stack"),
    HomeData(profile = R.drawable.profile2, headLine = "\uD83C\uDFAF Anime Quest",text = "\uD83C\uDF38 Last chance to claim your Otaku Badge for the Ultimate Anime Stack!"),
    HomeData(profile = R.drawable.profile3, headLine = "Prove You’re the True Otaku Master",text = "Final call — unlock your Slice of Life Badge in the Cozy Vibes Stack!", post = R.drawable.post1),
    HomeData(profile = R.drawable.profile4, headLine = "The Ultimate Anime Challenge",text = "Step into a world where dreams collide with destiny, and every episode brings you closer to becoming the ultimate anime legend.", post = R.drawable.poster3),
    HomeData(profile = R.drawable.profile5, headLine = "Step Into the World of Legends",text = "Step into the spotlight — get your Senpai Badge before the event ends!\n\nThe path to greatness isn’t easy — but with every badge you earn, your anime spirit grows stronger, burning brighter than ever before."),
    HomeData(profile = R.drawable.profile6, headLine = "Otaku Challenges",text = "Don’t blink! The Chibi Master Badge is only available for a limited time!"),
    HomeData(profile = R.drawable.profile7, headLine = "Unleash Your Inner Hero",text = "Collect your Nakama Badge and show your anime loyalty before it’s gone"),
    HomeData(profile = R.drawable.profile8, headLine = "Level-Up Zone",text = " Final call to prove your fandom — earn your Anime King Badge today", post = R.drawable.post2),
    HomeData(profile = R.drawable.profile9, headLine = "Rise of the Shonen Stack",text = " Hurry — unlock the Dream Sequence Badge for the Romance Stack", post = R.drawable.post3),
    HomeData(profile = R.drawable.profile10, headLine = "Your Journey Through the Anime Multiverse",text = "Don’t let your Senpai down — grab your Comedy Stack Badge before it’s gone"),
    HomeData(profile = R.drawable.profile11, headLine = "Rebirth Challenge",text = "Only true fans finish their ramen and claim the Anime Lover Badge", post = R.drawable.post4),
    HomeData(profile = R.drawable.profile12, headLine = "Complete Challenges, Earn Epic Badges",text = "Wake up, hero! The Protagonist Badge won’t wait forever."),
)

val discussionDataList = mutableListOf(
    DiscussionData(profile = R.drawable.profile12, accName = "The Crib", text = "Everyone is Welcome to come chill and talk about anything! One of the most active clubs on MAL."),
    DiscussionData(profile = R.drawable.profile11, accName = "Balkan anime club", text = "The title is quite self explanatory"),
    DiscussionData(profile = R.drawable.profile10, accName = "Otaku clan", text = "if you wanna relax come here, everyone can come as long as they can breath"),
    DiscussionData(profile = R.drawable.profile9, accName = "Anime Universe", text = "Join us to discuss all anime — from classics to the newest seasonal hits!"),
    DiscussionData(profile = R.drawable.profile8, accName = "Chill Weebs", text = "Laid-back space for memes, anime talk, and random chaos. No stress, just vibes."),
    DiscussionData(profile = R.drawable.profile7, accName = "Manga Maniacs", text = "Weekly manga discussions and spoiler talks. Beware, we read ahead!"),
    DiscussionData(profile = R.drawable.profile6, accName = "Slice of Life Society", text = "For fans of cozy anime, heartfelt moments, and calm storytelling."),
    DiscussionData(profile = R.drawable.profile5, accName = "Shonen Legends", text = "Naruto, One Piece, DBZ, JJK — you name it, we hype it! Power up with us."),
    DiscussionData(profile = R.drawable.profile4, accName = "RomCom Realm", text = "Talk about your favorite romantic comedies, ships, and heartbreak moments."),
    DiscussionData(profile = R.drawable.profile3, accName = "Late Night Otakus", text = "Where the night owls gather to talk anime, life, and random stuff."),
    DiscussionData(profile = R.drawable.profile2, accName = "VA Fans Hub", text = "Dedicated to voice actors and the art of bringing anime characters to life!"),
    DiscussionData(profile = R.drawable.profile1, accName = "Cosplay Corner", text = "Share your cosplay fits, tips, and experiences from cons around the world."),
)