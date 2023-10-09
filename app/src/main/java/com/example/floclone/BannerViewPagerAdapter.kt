package com.example.floclone

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment){

    private val fragmentList : ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size-1) // 몇 번 인덱스에 아이템이 insert됐는지 adapter에게 알려줌
    }
}