package com.example.floclone

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface AlbumDao{
    @Transaction
    @Query("select * from Album where (name = :albumName)")
    fun getSongsByAlbum(albumName: String) : Array<SongEntity>

    @Query("select * from Album")
    fun getAll():List<AlbumEntity>

}

@Dao
interface SongDao{
    @Query("select * from Song")
    fun getAll(): List<SongEntity>

    @Query("select * from Song where albumName = :albumName")
    fun getSongsByAlbumName(albumName:String)

    @Query("SELECT artist FROM Album where (name = (SELECT name FROM Song where albumName = :songName))")
    fun getArtist(songName:String) : String
}

