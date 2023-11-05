package com.example.floclone

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.floclone.database.SongDatabase
import com.example.floclone.database.SongViewModel
import com.example.floclone.databinding.ItemAlbumSongBinding
import org.w3c.dom.Text
import kotlin.concurrent.thread

class SongListRecyclerViewAdapter(private val songList: List<SongWithAlbum>) :
    RecyclerView.Adapter<SongListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("Adapter onCreateViewHolder", songList.toString())
        return ViewHolder(ItemAlbumSongBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = songList[position]
        Log.d("onBindViewHolder currentItem", currentItem.toString())
        holder.setData(currentItem)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    inner class ViewHolder(val binding: ItemAlbumSongBinding) : RecyclerView.ViewHolder(binding.root) {
        private val albumSongIDTextView:TextView = binding.albumSongIDTextView
        private val showTitleTextView : TextView = binding.showTitleTextView
        private val songNameTextView :TextView = binding.songNameTextView
        private val artistNameTextView:TextView = binding.artistNameTextView

        fun setData(songWithAlbum:SongWithAlbum){
            val songId = songWithAlbum.song.ID.toInt()
            albumSongIDTextView.text = songId.toString()

            if(songId == 1){
                showTitleTextView.visibility = View.VISIBLE
            }else{
                showTitleTextView.visibility = View.GONE
            }

            songNameTextView.text = songWithAlbum.song.name
            artistNameTextView.text = songWithAlbum.album.artist
        }

    }
}
