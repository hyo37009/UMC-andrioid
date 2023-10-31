package com.example.floclone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.example.floclone.*

@Database(entities = [SongEntity::class], version = 1)
@TypeConverter(Converters::class)
abstract class SongDatabase :RoomDatabase(){
    abstract fun songDao(): SongDao

    companion object{
        private var instance : SongDatabase? = null

        @Synchronized
        fun getInstance(context: Context): SongDatabase?{
            if (instance == null){
                synchronized(SongDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SongDatabase::class.java,
                        "song"
                    ).build()
                }
            }
            return instance
        }
    }

}

@Database(entities = [AlbumEntity::class], version = 1)
abstract class AlbumDatabase:RoomDatabase(){
    abstract fun albumDao():AlbumDao

    companion object{
        private var instance : AlbumDatabase? = null

        @Synchronized
        fun getInstance(context:Context): AlbumDatabase?{
            if (instance == null)
                synchronized(AlbumDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AlbumDatabase::class.java,
                        "album"
                    ).build()
                }
            return instance
        }
    }
}