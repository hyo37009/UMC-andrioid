package com.example.floclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floclone.R
import com.example.floclone.databinding.ItemMainImageViewpagerBinding
import com.example.floclone.item.mainViewPagerItem

class MainImageViewPagerAdapter(var itemList: List<mainViewPagerItem>):RecyclerView.Adapter<MainImageViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainImageViewPagerAdapter.ViewHolder {
        return ViewHolder(ItemMainImageViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MainImageViewPagerAdapter.ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.setData(currentItem)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(val binding: ItemMainImageViewpagerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(item: mainViewPagerItem) {
            binding.imageView.setImageDrawable(item.backGroundImage)
            binding.mainTextView.text = item.title
            binding.numberOfSongsTextView.text = binding.root.context
                .getString(R.string.MainVPSongCount).format(item.songCount)
            binding.dateTextView.text = item.date
            binding.albumImageView1.setImageBitmap(item.song1.album.coverImage)
            binding.albumImageView2.setImageBitmap(item.song2.album.coverImage)

        }

    }
}