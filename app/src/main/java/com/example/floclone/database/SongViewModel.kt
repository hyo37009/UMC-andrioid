package com.example.floclone.database

import android.app.Application
import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.floclone.SongWithAlbum
import com.example.floclone.adapter.MainImageViewPagerAdapter

class SongViewModel() : ViewModel() {

    fun getSongByName(context: Context, name: String): SongWithAlbum {
        return SongDatabaseRepository.getSongByName(context, name)
    }


    fun getSongsByAlbumName(context: Context, name: String): List<SongWithAlbum> {
        return SongDatabaseRepository.getSongsByAlbumName(context, name)
    }

    fun getSongById(context: Context, id: Int): SongWithAlbum {
        return SongDatabaseRepository.getSongById(context, id)
    }

    class Factory() : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SongViewModel() as T
        }
    }
}