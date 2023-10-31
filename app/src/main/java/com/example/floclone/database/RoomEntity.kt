package com.example.floclone

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

@Entity(tableName = "Album")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var ID: Long? = null,

    @ColumnInfo
    var name: String = "",

    @ColumnInfo
    var artist:String = "",

    @ColumnInfo
    var coverImage:Bitmap? = null,
)

@Entity(
    tableName = "Song",
    foreignKeys = [
        ForeignKey(
            entity = AlbumEntity::class,
            parentColumns = arrayOf("artist"),
            childColumns = arrayOf("artist"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SongEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var ID: Long? = null,

    @ColumnInfo
    var albumName: String = "",

    @ColumnInfo
    var trackId: Long = 0,

    @ColumnInfo
    var name: String = "",

    @ColumnInfo
    var artist : String = ""
)

data class AlbumWithSongs(
    @Embedded
    val album:AlbumEntity,
    @Relation(
        parentColumn = "name",
        entityColumn = "album"
    )
    val songLists: List<SongEntity>
)

