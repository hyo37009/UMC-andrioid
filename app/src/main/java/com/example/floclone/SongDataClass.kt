package com.example.floclone

import java.io.Serializable

data class SongDataClass(
    val title: String = "",
    val artist: String = "",
    val coverImageResource: Int = 0
) : Serializable
