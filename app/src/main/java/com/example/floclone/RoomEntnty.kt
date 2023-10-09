package com.example.floclone

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "Song")
data class RoomSongEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Long? = null,

    @ColumnInfo
    var Album: String = "",

    @ColumnInfo
    var trackId: Long = 0,

    @ColumnInfo
    var name: String = "",
)

@Entity(tableName = "Album")
data class RoomAlbumEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Long? = null,

    @ColumnInfo
    var Album: String = "",

    @ColumnInfo
    var TrackID: Long = 0
)

data class AlbumWithSongs(
    @Embedded
    val album:RoomAlbumEntity,
    @Relation(
        parentColumn = "Album",
        entityColumn = "Album"
    )
    val songlists: List<RoomSongEntity>
)

