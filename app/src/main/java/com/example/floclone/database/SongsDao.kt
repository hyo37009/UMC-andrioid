package com.example.floclone

import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface AlbumDao{
    @Transaction
    @Query("select * from Album where (name = :albumName)")
    fun getAlbum(albumName: String) : AlbumEntity

    @Query("select * from Album")
    fun getAll():List<AlbumEntity>

}

@Dao
interface SongDao{
    @Query("select * from Song")
    fun getAll(): List<SongEntity>

    @Query("select * from Song where albumName = :albumName")
    fun getSongsByAlbumName(albumName:String) : List<SongEntity>

    @Query("SELECT artist FROM Album where (name = (SELECT name FROM Song where albumName = :songName))")
    fun getArtist(songName:String) : String

}

