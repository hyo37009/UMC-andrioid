package com.example.floclone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.floclone.database.SongDatabase
import com.example.floclone.databinding.FragmentAlbumBinding
import kotlin.concurrent.thread


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

        var savedSongs = listOf<SongEntity>()
//        savedSongs = database.songDao()?.getSongsByAlbumName("Bee and The Whales")!!
//        val r = Runnable {
//        }
//        val thread = Thread(r)
//        thread.start()
        thread(start = true){
            Log.d("db", database.songDao().getAll().toString())
            savedSongs = database.songDao().getSongsByAlbumName("Bee and The Whales")
            Log.d("savedSongs", savedSongs.toString())
        }


        if(savedSongs.isNotEmpty()){
            songList.addAll(savedSongs)
        }

        Log.d("list", songList.toString())

        adapter = SongListRecyclerViewAdapter()
        binding.songRecyclerView.adapter = adapter
        adapter.setData(songList)

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