package com.example.floclone

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqliteHelper(context: Context, name:String, version:Int)
    : SQLiteOpenHelper(context, name, null, version){
    override fun onCreate(db: SQLiteDatabase?) {
        val create = ""
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}