package com.example.floclone.database

import android.content.Context
import com.example.floclone.SongDao
import com.example.floclone.SongWithAlbum

class SongDatabaseRepository(private val songDaO: SongDao) {
    companion object{
        var songDatabase: SongDatabase? = null
        var SwADatabase:SongWithAlbumDatabase? = null

        fun initalizeSongDB(context: Context) : SongDatabase{
            return SongDatabase?.getInstance(context)!!
        }

        fun initalizeSwADB(context: Context):SongWithAlbumDatabase{
            return SongWithAlbumDatabase?.getInstance(context)!!
        }

        fun getSongByName(context: Context, name:String) : SongWithAlbum {
            SwADatabase = initalizeSwADB(context)
            return SwADatabase?.songWithAlbumDao()!!.getSongByName(name)
        }


        fun getSongsByAlbumName(context: Context, name: String) : List<SongWithAlbum>{
            SwADatabase = initalizeSwADB(context)
            return SwADatabase?.songWithAlbumDao()!!.getSongsByAlbumName(name)
        }

        fun getSongById(context: Context, id:Int) : SongWithAlbum{
            SwADatabase = initalizeSwADB(context)
            return SwADatabase?.songWithAlbumDao()!!.getSongTrackId(id)
        }
    }
}