package com.example.floclone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.floclone.databinding.ItemAlbumSongBinding

class SongListRecyclerViewAdapter:RecyclerView.Adapter<Holder>() {
    var helper:RoomHelper? = null
    val listData = mutableListOf<RoomSongEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemAlbumSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val song = listData.get(position)
        holder.setSong(song)
    }
}

class Holder(val binding: ItemAlbumSongBinding) : RecyclerView.ViewHolder(binding.root){
    fun setSong(song:RoomSongEntity){
        binding.albumSongIDTextView.text = song.id.toString()
        binding.songNameTextView.text = song.name
        binding.artistNameTextView.text = song.Album
    }
}