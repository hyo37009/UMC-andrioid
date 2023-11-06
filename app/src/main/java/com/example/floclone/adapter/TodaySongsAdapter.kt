package com.example.floclone.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floclone.SongWithAlbum
import com.example.floclone.activity.MainActivity
import com.example.floclone.databinding.ItemAlbumSongBinding
import com.example.floclone.databinding.ItemTodayAlbumBinding
import com.example.floclone.fragment.HomeFragment

class TodaySongsAdapter(private val songList: List<SongWithAlbum>, val homeFragment: HomeFragment):RecyclerView.Adapter<TodaySongsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodaySongsAdapter.ViewHolder {
        val binding = ItemTodayAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodaySongsAdapter.ViewHolder, position: Int) {
        val currentItem = songList[position]
        holder.setData(currentItem)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    inner class ViewHolder(private val binding:ItemTodayAlbumBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(songWithAlbum:SongWithAlbum){
            binding.songTitleTextView.text = songWithAlbum.song.name
            binding.artistNameTextView.text = songWithAlbum.album.artist
            binding.albumImageView.setImageBitmap(songWithAlbum.album.coverImage)

            binding.root.setOnClickListener {
                homeFragment.changeNowSongStatus(songWithAlbum)
                homeFragment.startAlbumFragment()
            }
        }

    }
}