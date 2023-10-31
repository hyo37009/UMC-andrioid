package com.example.floclone.database

import java.io.Serializable

data class SongDataClass(
    val id : Int,
    val title: String,
    val artist: String,
    val coverImageResource: Int
) : Serializable


