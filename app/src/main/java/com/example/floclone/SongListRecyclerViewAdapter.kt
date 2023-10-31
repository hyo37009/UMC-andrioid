package com.example.floclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floclone.database.SongDatabase
import com.example.floclone.database.SongViewModel
import com.example.floclone.databinding.ItemAlbumSongBinding

class SongListRecyclerViewAdapter(private val songList: List<SongEntity>):RecyclerView.Adapter<SongListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAlbumSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = songList[position]
        val nowId = currentItem.ID

        holder.binding.albumSongIDTextView.text = nowId.toString()
        holder.binding.songNameTextView.text = currentItem.name
        holder.binding.artistNameTextView.text = currentItem.artist

        if (nowId!!.toInt() == 1){
            holder.binding.showTitleTextView.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int {
        return songList.size
    }

    class ViewHolder(val binding:ItemAlbumSongBinding):RecyclerView.ViewHolder(binding.root)
}
