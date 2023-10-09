package com.example.floclone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floclone.databinding.ItemAlbumSongBinding

class SongListAdapter:RecyclerView.Adapter<Holder>() {
    val listData = mutableListOf<Song>()
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
    fun setSong(song:Song){
        binding.albumSongIDTextView.text = song.TrackID.toString()
        binding.songNameTextView.text = song.name
        binding.artistNameTextView.text =
    }
}