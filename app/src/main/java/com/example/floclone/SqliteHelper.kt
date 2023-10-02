package com.example.floclone

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable

class SqliteHelper(context: Context, name:String, version:Int)
    : SQLiteOpenHelper(context, name, null, version){
    override fun onCreate(db: SQLiteDatabase?) {
        val create = ""
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}

data class Song(var ID:Long?, var TrackID:Int, var name: String)

data class Album(var ID:Long?, var Artist:String, var Name:String, var CoverImage:BitmapDrawable)