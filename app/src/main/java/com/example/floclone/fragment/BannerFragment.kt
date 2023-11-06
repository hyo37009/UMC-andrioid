package com.example.floclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.floclone.databinding.FragmentBannerBinding

class BannerFragment(private val imageResource : Int) : Fragment() {
    lateinit var binding : FragmentBannerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBannerBinding.inflate(inflater, container, false)

        binding.bannerImageView.setImageResource(imageResource)

        return binding.root
    }
}