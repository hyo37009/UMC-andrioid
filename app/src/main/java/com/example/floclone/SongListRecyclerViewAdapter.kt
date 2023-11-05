package com.example.floclone

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

class SongListRecyclerViewAdapter(private val songList: List<SongEntity>):RecyclerView.Adapter<SongListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemAlbumSongBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = songList[position]
        val nowId = currentItem.ID

        holder.id.text = nowId.toString()
        holder.name.text = currentItem.name
        holder.artist.text = SongDatabase?.getInstance(context as MainActivity)!!.songDao().getArtist(currentItem.name)

//        if (nowId!!.toInt() == 1){
//            holder.binding.showTitleTextView.visibility = View.GONE
//        }
        return

    }

    override fun getItemCount(): Int {
        return songList.size
    }

    class ViewHolder(val binding:ItemAlbumSongBinding):RecyclerView.ViewHolder(binding.root) {
        val id : TextView = binding.albumSongIDTextView
        val name : TextView = binding.songNameTextView
        val artist : TextView = binding.artistNameTextView
        val isTitle : TextView = binding.showTitleTextView
    }
}
