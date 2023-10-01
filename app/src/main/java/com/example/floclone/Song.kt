package com.example.floclone

import java.io.Serializable

data class Song(
    val title: String = "",
    val artist: String = "",
    val coverImageResource: Int = 0
) : Serializable
