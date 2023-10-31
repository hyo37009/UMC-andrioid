package com.example.floclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.floclone.database.SongDatabase
import com.example.floclone.databinding.FragmentAlbumBinding


class AlbumFragment() : Fragment() {
    lateinit var binding: FragmentAlbumBinding
    private lateinit var adapter:SongListRecyclerViewAdapter
    lateinit var database: SongDatabase
    var songList = mutableListOf<SongEntity>()
    val TAG = "AlbumFragment"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(layoutInflater)
        database = SongDatabase.getInstance(activity as MainActivity)!!
        val savedSongs = database.songDao().getAll()
        if(savedSongs.isNotEmpty()){
            songList.addAll(savedSongs)
        }
        adapter = SongListRecyclerViewAdapter(songList)
        binding.songRecyclerView.adapter = adapter

        binding.finishImageButton.setOnClickListener {
            startHomeFragment()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun startHomeFragment() {
        val fragment: Fragment = HomeFragment()
        val transaction = (activity as MainActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}