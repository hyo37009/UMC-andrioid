package com.example.floclone

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.drawable.BitmapDrawable

class SqliteHelper(context: Context, name:String, version:Int)
    : SQLiteOpenHelper(context, name, null, version){
    override fun onCreate(db: SQLiteDatabase?) {
        // 데이터가 생성되어있지 않을 때 실행
        // 이미 작성했으니까 일단 넘어감
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun selectSong():MutableList<Song>{
        val list = mutableListOf<Song>()

        val select = "select * from Song"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select, null)

        while(cursor.moveToNext()){
            val idIdx = cursor.getColumnIndex("ID")
            val albumIdx = cursor.getColumnIndex("Album")
            val trackIdIdx = cursor.getColumnIndex("TrackID")
            val nameIdx = cursor.getColumnIndex("Name")

            val id = cursor.getLong(idIdx)
            val album = cursor.getString(albumIdx)
            val trackId = cursor.getLong(trackIdIdx)
            val name = cursor.getString(nameIdx)

            list.add(Song(id, album, trackId, name))
        }
        cursor.close()
        rd.close()

        return list
    }

    fun selectAlbum():MutableList<Album>{
        val list = mutableListOf<Album>()

        val select = "select * from Album"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select, null)

        while(cursor.moveToNext()){
            val idIdx = cursor.getColumnIndex("ID")
            val artistIdx = cursor.getColumnIndex("Artist")
            val nameIdx = cursor.getColumnIndex("Name")
            val coverImageIdx = cursor.getColumnIndex("CoverImage")

            val id = cursor.getLong(idIdx)
            val artist = cursor.getString(artistIdx)
            val name = cursor.getString(nameIdx)
            val coverImage = cursor.getBlob(coverImageIdx)

            list.add(Album(id, artist, name, coverImage))
        }
        cursor.close()
        rd.close()

        return list
    }

}

data class Song(var ID:Long?, var Album:String, var TrackID:Long, var name: String)

data class Album(var ID:Long?, var Artist:String, var Name:String, var CoverImage:ByteArray)
