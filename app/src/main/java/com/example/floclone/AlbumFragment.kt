package com.example.floclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.example.floclone.databinding.FragmentAlbumBinding


class AlbumFragment(val nowAlbum:RoomAlbumEntity) : Fragment() {
    var helper:RoomHelper ?= null
    lateinit var binding: FragmentAlbumBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        helper = Room.databaseBuilder((context as MainActivity), RoomHelper::class.java, "room_songs")
            .allowMainThreadQueries()
            .build()
        val adapter = SongListRecyclerViewAdapter()
        adapter.helper = helper
        adapter.listData.addAll(helper?.SongDao()?.getSongsByAlbumName(nowAlbum.Album)?: listOf())
        binding = FragmentAlbumBinding.inflate(layoutInflater)

//        val nowSong = (activity as MainActivity).returnNowSong()
//        binding.songNameTextView.text = nowSong.title
//        binding.artistTextView.text = nowSong.artist
//        binding.imageView.setImageDrawable(ContextCompat.getDrawable((context as MainActivity),nowSong.coverImageResource))

        binding.finishImageButton.setOnClickListener {
            startHomeFragment()
        }


        return binding.root
    }

    private fun startHomeFragment() {
        val fragment:Fragment = HomeFragment()
        val transaction = (activity as MainActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}