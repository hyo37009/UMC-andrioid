package com.example.floclone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.floclone.R
import com.example.floclone.SongWithAlbum
import com.example.floclone.databinding.ActivityMainBinding
import com.example.floclone.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var nowSong: SongWithAlbum? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        initFragment()

        binding.miniPlayerContainer.setOnClickListener {
            startSongActivity()
        }
    }

    private fun startSongActivity() {
        val intent = Intent(this, SongActivity::class.java)
        startActivity(intent)
    }

    private fun initFragment() {
        val fragment:Fragment = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, fragment)
        transaction.commit()
    }

    fun changeMiniPlayerInfo(nowSong: SongWithAlbum) {
        this.nowSong = nowSong
        binding.miniPlayerSongNameTextView.text = nowSong.song.name
        binding.miniPlayerArtistNameTextView.text = nowSong.album.artist
    }


}