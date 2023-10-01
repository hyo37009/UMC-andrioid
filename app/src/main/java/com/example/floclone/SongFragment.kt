package com.example.floclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.floclone.databinding.FragmentSongBinding


class SongFragment : Fragment() {
    lateinit var binding: FragmentSongBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(layoutInflater)

        val nowSong = (activity as MainActivity).returnNowSong()
        binding.songNameTextView.text = nowSong.title
        binding.artistTextView.text = nowSong.artist
        binding.imageView.setImageDrawable(ContextCompat.getDrawable((context as MainActivity),nowSong.coverImageResource))

        binding.finishImageButton.setOnClickListener {
            startHomeFragment()
        }


        return binding.root
    }

    private fun startHomeFragment() {
        val fragment:Fragment = HomeFragment()
        val transaction = (activity as MainActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}