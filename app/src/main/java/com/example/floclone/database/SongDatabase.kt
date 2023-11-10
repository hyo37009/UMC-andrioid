package com.example.floclone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.floclone.*

@Database(
    version = 2,
    entities = [SongEntity::class, AlbumEntity::class])
@TypeConverters(bitmapByteArrayConverters::class)
abstract class SongDatabase :RoomDatabase(){
    abstract fun songDao(): SongDao

    companion object{
        private var instance : SongDatabase? = null

        @Synchronized
        fun getInstance(context: Context): SongDatabase?{
            return Room.databaseBuilder(context, SongDatabase::class.java, "song")
                .createFromAsset("song.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}

@Database(entities = [AlbumEntity::class], version = 1)
@TypeConverters(bitmapByteArrayConverters::class)
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

@Database(entities = [AlbumEntity::class, SongEntity::class], version = 1)
@TypeConverters(bitmapByteArrayConverters::class)
abstract class SongWithAlbumDatabase:RoomDatabase(){
    abstract fun songWithAlbumDao():SongWithAlbumDao

    companion object{
        private var instance : SongWithAlbumDatabase? = null

        @Synchronized
        fun getInstance(context:Context): SongWithAlbumDatabase?{
            return Room.databaseBuilder(context, SongWithAlbumDatabase::class.java, "song")
                .createFromAsset("song.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}