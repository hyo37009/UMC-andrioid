package com.example.floclone

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

@Entity(
    tableName = "Song",
    foreignKeys = [
        ForeignKey(
            entity = AlbumEntity::class,
            parentColumns = arrayOf("name"),
            childColumns = arrayOf("albumName")
        )
    ]
)
data class SongEntity(
    @ColumnInfo
    var albumName: String? = "",

    @ColumnInfo
    var trackId: Long? = 0,

    @ColumnInfo
    var name: String? = "",


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var ID: Long = 0
)

@Entity(tableName = "Album")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo
    var name: String = "",

    @ColumnInfo
    var artist: String = "",

    @ColumnInfo
    var coverImage: Bitmap? = null,
)

data class AlbumWithSongs(
    @Embedded
    val album: AlbumEntity,
    @Relation(
        parentColumn = "name",
        entityColumn = "album"
    )
    val songLists: List<SongEntity>
)

