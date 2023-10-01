package com.example.floclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.floclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val asobo =
            Song("汐", "Galileo Galilei", R.drawable.img_album_galileogalilei_bee_and_the_whales)
        binding.todayAlbumTitle1.text = asobo.title
        binding.todayAlbumArtist1.text = asobo.artist
        binding.todayAlbumImage1.setImageDrawable(getDrawable(asobo.coverImageResource))
        val augustIsMyName = Song("八月は僕の名前", "Quruli", R.drawable.img_album_qururi_august)
        binding.todayAlbumTitle2.text = augustIsMyName.title
        binding.todayAlbumArtist2.text = augustIsMyName.artist
        binding.todayAlbumImage2.setImageDrawable(getDrawable(augustIsMyName.coverImageResource))
        val yaritaikoto = Song("やりたいこと", "warbear", R.drawable.img_album_warbear_warbear)
        binding.todayAlbumTitle3.text = yaritaikoto.title
        binding.todayAlbumArtist3.text = yaritaikoto.artist
        binding.todayAlbumImage3.setImageDrawable(getDrawable(yaritaikoto.coverImageResource))

        var nowsong: Song = asobo


        binding.todayAlbumImage1.setOnClickListener {
            nowsong = asobo
            changeMiniPlayerInfo(nowsong)
        }
        binding.todayAlbumImage2.setOnClickListener {
            nowsong = augustIsMyName
            changeMiniPlayerInfo(nowsong)
        }
        binding.todayAlbumImage3.setOnClickListener {
            nowsong = yaritaikoto
            changeMiniPlayerInfo(nowsong)
        }

        binding.miniPlayerContainer.setOnClickListener {
            val intent = Intent(this, SongActivity::class.java)
            intent.putExtra("title", nowsong.title)
            intent.putExtra("artist", nowsong.artist)
            intent.putExtra("cover", nowsong.coverImageResource)
            startActivity(intent)
        }

    }

    private fun changeMiniPlayerInfo(song: Song) {
        binding.miniPlayerSongNameTextView.text = song.title
        binding.miniPlayerArtistNameTextView.text = song.artist

    }


}