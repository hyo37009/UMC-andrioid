package com.example.floclone.database

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.floclone.AlbumDao
import com.example.floclone.AlbumEntity
import com.example.floclone.SongDao
import com.example.floclone.SongEntity

class SongRepository(private val songDaO: SongDao) {
    val readAllData:List<SongEntity> = songDaO.getAll()

    suspend fun readArtistName(song:SongEntity):String{
        return songDaO.getArtist(song.albumName)
    }
}

class AlbumRepository(private val albumDao: AlbumDao){
    val readAllData:List<AlbumEntity> = albumDao.getAll()
}