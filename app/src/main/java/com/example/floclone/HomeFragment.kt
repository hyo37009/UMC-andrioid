package com.example.floclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.floclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val asobo =
            Song("汐", "Galileo Galilei", R.drawable.img_album_galileogalilei_bee_and_the_whales)
        binding.todayAlbumTitle1.text = asobo.title
        binding.todayAlbumArtist1.text = asobo.artist
        binding.todayAlbumImage1.setImageDrawable(ContextCompat.getDrawable((context as MainActivity), asobo.coverImageResource))
        val augustIsMyName = Song("八月は僕の名前", "Quruli", R.drawable.img_album_qururi_august)
        binding.todayAlbumTitle2.text = augustIsMyName.title
        binding.todayAlbumArtist2.text = augustIsMyName.artist
        binding.todayAlbumImage2.setImageDrawable(ContextCompat.getDrawable((context as MainActivity),augustIsMyName.coverImageResource))
        val yaritaikoto = Song("やりたいこと", "warbear", R.drawable.img_album_warbear_warbear)
        binding.todayAlbumTitle3.text = yaritaikoto.title
        binding.todayAlbumArtist3.text = yaritaikoto.artist
        binding.todayAlbumImage3.setImageDrawable(ContextCompat.getDrawable((context as MainActivity),yaritaikoto.coverImageResource))


        var nowSong:Song = (activity as MainActivity).nowSong ?: asobo

        binding.todayAlbumImage1.setOnClickListener {
            nowSong = asobo
            changeNowSongStatus(nowSong)
            startSongFragment()
        }

        binding.todayAlbumImage2.setOnClickListener {
            nowSong = augustIsMyName
            changeNowSongStatus(nowSong)
            startSongFragment()
        }

        binding.todayAlbumImage3.setOnClickListener {
            nowSong = yaritaikoto
            changeNowSongStatus(nowSong)
            startSongFragment()
        }

        return binding.root
    }

    private fun startSongFragment() {
        val fragment:Fragment = SongFragment()
        val transaction = (activity as MainActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
            .commit()
    }

    private fun changeNowSongStatus(nowSong: Song) {
        (activity as MainActivity).changeMiniPlayerInfo(nowSong)

    }
}