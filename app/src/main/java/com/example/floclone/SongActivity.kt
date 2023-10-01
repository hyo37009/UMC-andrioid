package com.example.floclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.floclone.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    lateinit var binding: ActivitySongBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        binding.songNameTextView.text = intent.getStringExtra("title")
        binding.artistTextView.text = intent.getStringExtra("artist")
        binding.imageView.setImageDrawable(getDrawable(intent.getIntExtra("cover", 0)))
    }
}