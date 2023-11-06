package com.example.floclone

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface AlbumDao {
    @Transaction
    @Query("select * from Album where (name = :albumName)")
    fun getAlbum(albumName: String): AlbumEntity

    @Query("select * from Album")
    fun getAll(): List<AlbumEntity>

    @Query("select name from Album")
    fun getAllAlbumNames(): List<String>

}

@Dao
interface SongDao {
    @Query("select * from Song")
    fun getAll(): List<SongEntity>

    @Query("select * from Song where albumName = :albumName")
    fun getSongsByAlbumName(albumName: String): List<SongEntity>

    @Query("SELECT artist FROM Album where (name = (SELECT name FROM Song where albumName = :songName))")
    fun getArtist(songName: String): String

    @Transaction
    @Query("SELECT * FROM Song where albumName = :albumName")
    fun getSongsWithAlbumByAlbumName(albumName: String): List<SongWithAlbum>

    // 오늘의 노래에 들어갈 항목. 원래는 여기서 정의할 것이 아니지만 임시로 작성하였음
    @Transaction
    @Query("select * from Song where ID = 8 or ID = 15 or ID = 16 or ID = 28")
    fun getTodaySongs():List<SongWithAlbum>

}

