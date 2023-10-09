package com.example.floclone

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(RoomSongEntity::class), (RoomAlbumEntity::class)], version = 1)
abstract class RoomHelper :RoomDatabase(){
    abstract fun SongDao():SongDaO
    abstract fun AlbumDao():AlbumDao

}