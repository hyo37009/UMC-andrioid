package com.example.floclone.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.floclone.activity.MainActivity
import com.example.floclone.R
import com.example.floclone.SongWithAlbum
import com.example.floclone.adapter.BannerViewPagerAdapter
import com.example.floclone.adapter.TodaySongsAdapter
import com.example.floclone.database.SongDatabase
import com.example.floclone.database.SongWithAlbumDatabase
import com.example.floclone.databinding.FragmentHomeBinding
import kotlin.concurrent.thread

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var todaySongs:List<SongWithAlbum>
    lateinit var mainActivity: MainActivity
    lateinit var nowSong:SongWithAlbum
    lateinit var database: SongDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        // 오늘의 노래 리사이클러뷰
        thread(start = true){
            database = SongDatabase?.getInstance(mainActivity)!!

        }
        Thread.sleep(500)
        nowSong = todaySongs[0]

        binding.todayAlbumRecyclerView.adapter = TodaySongsAdapter(todaySongs, this)
        binding.todayAlbumRecyclerView.layoutManager = LinearLayoutManager(this.activity).also { it.orientation = LinearLayoutManager.HORIZONTAL }


        // 배너 리사이클러뷰
        val bannerAdapter = BannerViewPagerAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerViewPager.adapter = bannerAdapter
        binding.homeBannerViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 뷰페이져 스크롤 방향 설정


        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    fun startAlbumFragment() {
        val fragment:Fragment = AlbumFragment(nowSong)
        val transaction = (activity as MainActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
            .commit()
    }

    fun changeNowSongStatus(nowSong: SongWithAlbum) {
        this.nowSong = nowSong
        (activity as MainActivity).changeMiniPlayerInfo(nowSong)
    }
}