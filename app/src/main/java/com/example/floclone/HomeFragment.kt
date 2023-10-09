package com.example.floclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.floclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

//        val asobo =
//            SongDataClass("汐", "Galileo Galilei", R.drawable.img_album_galileogalilei_bee_and_the_whales)
//        binding.todayAlbumTitle1.text = asobo.title
//        binding.todayAlbumArtist1.text = asobo.artist
//        binding.todayAlbumImage1.setImageDrawable(ContextCompat.getDrawable((context as MainActivity), asobo.coverImageResource))
//        val augustIsMyName = SongDataClass("八月は僕の名前", "Quruli", R.drawable.img_album_qururi_august)
//        binding.todayAlbumTitle2.text = augustIsMyName.title
//        binding.todayAlbumArtist2.text = augustIsMyName.artist
//        binding.todayAlbumImage2.setImageDrawable(ContextCompat.getDrawable((context as MainActivity),augustIsMyName.coverImageResource))
//        val yaritaikoto = SongDataClass("やりたいこと", "warbear", R.drawable.img_album_warbear_warbear)
//        binding.todayAlbumTitle3.text = yaritaikoto.title
//        binding.todayAlbumArtist3.text = yaritaikoto.artist
//        binding.todayAlbumImage3.setImageDrawable(ContextCompat.getDrawable((context as MainActivity),yaritaikoto.coverImageResource))
//
//
//        var nowSongDataClass:SongDataClass = (activity as MainActivity).nowSongDataClass ?: asobo
//
//        binding.todayAlbumImage1.setOnClickListener {
//            nowSongDataClass = asobo
//            changeNowSongStatus(nowSongDataClass)
//            startSongFragment()
//        }
//
//        binding.todayAlbumImage2.setOnClickListener {
//            nowSongDataClass = augustIsMyName
//            changeNowSongStatus(nowSongDataClass)
//            startSongFragment()
//        }
//
//        binding.todayAlbumImage3.setOnClickListener {
//            nowSongDataClass = yaritaikoto
//            changeNowSongStatus(nowSongDataClass)
//            startSongFragment()
//        }

        val bannerAdapter = BannerViewPagerAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerViewPager.adapter = bannerAdapter
        binding.homeBannerViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 뷰페이져 스크롤 방향 설정


        return binding.root
    }

    private fun startSongFragment() {
        val fragment:Fragment = SongFragment()
        val transaction = (activity as MainActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
            .commit()
    }

    private fun changeNowSongStatus(nowSongDataClass: SongDataClass) {
        (activity as MainActivity).changeMiniPlayerInfo(nowSongDataClass)

    }
}