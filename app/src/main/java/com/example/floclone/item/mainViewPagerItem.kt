package com.example.floclone.item

import android.graphics.drawable.Drawable
import com.example.floclone.SongEntity
import com.example.floclone.SongWithAlbum

class mainViewPagerItem(
    var backGroundImage: Drawable,
    var title: String,
    var songCount: Int,
    var date: String,
    var song1: SongWithAlbum,
    var song2: SongWithAlbum
){
    init {

    }
}