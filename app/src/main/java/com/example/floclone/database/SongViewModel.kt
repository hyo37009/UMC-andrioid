package com.example.floclone.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.floclone.AlbumEntity
import com.example.floclone.SongEntity

class SongViewModel (application: Application):AndroidViewModel(application) {
    private val readAllSongData : List<SongEntity>
    private val readAllAlbumData : List<AlbumEntity>
    private val songRepository : SongRepository
    private val albumRepository : AlbumRepository

    init{
        val songDao = SongDatabase.getInstance(application)!!.songDao()
        songRepository = SongRepository(songDao)
        readAllSongData = songRepository.readAllData

        val albumDao = AlbumDatabase.getInstance(application)!!.albumDao()
        albumRepository = AlbumRepository(albumDao)
        readAllAlbumData = albumRepository.readAllData
    }

//    class Factory(val application: Application) : ViewModelProvider.Factory{
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            return SongViewModel(application) as T
//        }
//    }
}