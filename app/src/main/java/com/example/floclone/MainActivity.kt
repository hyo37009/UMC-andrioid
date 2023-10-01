package com.example.floclone

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.floclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var nowSong:Song ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        initFragment()
    }

    private fun initFragment() {
        val fragment:Fragment = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, fragment)
        transaction.commit()
    }

    fun changeMiniPlayerInfo(song: Song) {
        nowSong = song
        binding.miniPlayerSongNameTextView.text = nowSong?.title
        binding.miniPlayerArtistNameTextView.text = nowSong?.artist
    }

    fun returnNowSong() : Song{
        nowSong = this.nowSong ?: Song("null", "null", R.drawable.img_album_exp)
        return nowSong as Song
    }


}