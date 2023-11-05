package com.example.floclone

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.floclone.database.SongDatabase
import com.example.floclone.databinding.FragmentAlbumBinding
import kotlin.concurrent.thread


class AlbumFragment() : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var binding: FragmentAlbumBinding
    private lateinit var adapter:SongListRecyclerViewAdapter
    lateinit var database: SongDatabase
    lateinit var SongsWithAlbum: List<SongWithAlbum>
    val TAG = "AlbumFragment"
    val nowAlbumName = "Bee and The Whales"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(layoutInflater)
        database = SongDatabase?.getInstance(mainActivity)!!
        thread(start = true){
            // 데이터 불러오려면 새로운 스레드를 열어야함.
            // 클릭한 앨범 정보를 받아 이에 맞는 db를 불러와야하는데 일단 임의로 고정해둠.
            SongsWithAlbum = database.songDao().getSongsWithAlbumByAlbumName(nowAlbumName)
            Log.d("dbAlbumSongs1", SongsWithAlbum.toString())
        }
        Thread.sleep(500)
        Log.d("dbAlbumSongs2", SongsWithAlbum.toString())


        val adapter = SongListRecyclerViewAdapter(SongsWithAlbum)

        binding.songRecyclerView.adapter = adapter
        binding.songRecyclerView.layoutManager = LinearLayoutManager(this.activity)


        binding.finishImageButton.setOnClickListener {
            startHomeFragment()
        }

        binding.songRecyclerView.setOnClickListener{
            Log.d("songRecyclerView", "clicked")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var albumSongs = listOf<SongEntity>()
//        thread(start = true){
//            // 데이터 불러오려면 새로운 스레드를 열어야함.
//            // 클릭한 앨범 정보를 받아 이에 맞는 db를 불러와야하는데 일단 임의로 고정해둠.
//            Log.d("dbGetAll", database.songDao().getAll().toString())
//            albumSongs = database.songDao().getSongsByAlbumName("Bee and The Whales")
//            Log.d("dbAlbumSongs", albumSongs.toString())
//        }
//        Log.d("dbAlbumSongs2", albumSongs.toString())
////
//        adapter = SongListRecyclerViewAdapter(albumSongs)
//        adapter.database = database
//
//        binding.songRecyclerView.adapter = adapter
//        binding.songRecyclerView.layoutManager = LinearLayoutManager(this.activity)
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