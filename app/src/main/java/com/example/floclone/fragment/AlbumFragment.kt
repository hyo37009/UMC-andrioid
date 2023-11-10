package com.example.floclone.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.floclone.activity.MainActivity
import com.example.floclone.R
import com.example.floclone.SongWithAlbum
import com.example.floclone.adapter.SongListRecyclerViewAdapter
import com.example.floclone.database.SongDatabase
import com.example.floclone.database.SongViewModel
import com.example.floclone.databinding.FragmentAlbumBinding
import kotlin.concurrent.thread


class AlbumFragment(private val nowSong:SongWithAlbum) : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var binding: FragmentAlbumBinding
    private lateinit var adapter: SongListRecyclerViewAdapter
    lateinit var database: SongDatabase
    lateinit var albumSongs: List<SongWithAlbum>
    val TAG = "AlbumFragment"
//    val nowAlbumName = "Bee and The Whales"

    lateinit var songViewModel: SongViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(layoutInflater)

        songViewModel = ViewModelProvider(this).get(SongViewModel::class.java)
        albumSongs = songViewModel.getSongsByAlbumName(mainActivity, nowSong.album.name)
//        database = SongDatabase?.getInstance(mainActivity)!!
//        thread(start = true) {
//            // 데이터 불러오려면 새로운 스레드를 열어야함.
//            // 클릭한 앨범 정보를 받아 이에 맞는 db를 불러와야하는데 일단 임의로 고정해둠.
//            albumSongs = database.songDao().getSongsWithAlbumByAlbumName(nowSong.album.name)
//            Log.d(TAG, nowSong.toString())
//        }
//        Thread.sleep(300)

        adapter = SongListRecyclerViewAdapter(albumSongs)

        binding.songRecyclerView.adapter = adapter
        binding.songRecyclerView.layoutManager = LinearLayoutManager(this.activity)

        val nowAlbum = nowSong.album

        binding.songNameTextView.text = nowSong.song.name
        binding.artistTextView.text = nowAlbum.artist
        binding.albumImageView.setImageBitmap(nowAlbum.coverImage)

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