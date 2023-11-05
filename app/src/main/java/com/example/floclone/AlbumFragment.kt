package com.example.floclone

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.example.floclone.database.SongDatabase
import com.example.floclone.databinding.ActivityMainBinding
import com.example.floclone.databinding.FragmentAlbumBinding
import java.io.File
import kotlin.concurrent.thread


class AlbumFragment() : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var binding: FragmentAlbumBinding
    private lateinit var adapter:SongListRecyclerViewAdapter
    lateinit var database: SongDatabase
    val TAG = "AlbumFragment"

    val nowAlbumName = "Bee and The Whales"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(layoutInflater)
        database = SongDatabase?.getInstance(mainActivity)!!

//        var savedSongs = listOf<SongEntity>()
//        thread(start = true){
//            Log.d("db", database.songDao().getAll().toString())
//            savedSongs = database.songDao().getSongsByAlbumName("Bee and The Whales")
//            Log.d("savedSongs", savedSongs.toString())
//        }

        var albumSongs = listOf<SongEntity>()
        thread(start = true){
            Log.d("dbGetAll", database.songDao().getAll().toString())
            albumSongs = database.songDao().getSongsByAlbumName("Bee and The Whales")
            Log.d("dbAlbumSongs", albumSongs.toString())
        }

        adapter = SongListRecyclerViewAdapter(albumSongs)
        binding.songRecyclerView.adapter = adapter

        binding.finishImageButton.setOnClickListener {
            startHomeFragment()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }

    private fun startHomeFragment() {
        val fragment: Fragment = HomeFragment()
        val transaction = (activity as MainActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}