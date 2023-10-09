package com.example.floclone

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface AlbumDao{
    @Transaction
    @Query("select * from Album")
    fun getAlbumsWithSongs(): List<AlbumWithSongs>

}

@Dao
interface SongDaO{
    @Query("select * from Song")
    fun getSongs(): List<RoomSongEntity>

    @Query("select * from Song where Album = :albumName")
    fun getSongsByAlbumName(albumName:String)
}