package com.example.floclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.floclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var nowSongDataClass:SongDataClass ?= null

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

    fun changeMiniPlayerInfo(songDataClass: SongDataClass) {
        nowSongDataClass = songDataClass
        binding.miniPlayerSongNameTextView.text = nowSongDataClass?.title
        binding.miniPlayerArtistNameTextView.text = nowSongDataClass?.artist
    }

    fun returnNowSong() : SongDataClass{
        nowSongDataClass = this.nowSongDataClass ?: SongDataClass("null", "null", R.drawable.img_album_exp)
        return nowSongDataClass as SongDataClass
    }


}