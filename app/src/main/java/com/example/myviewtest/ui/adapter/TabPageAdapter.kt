package com.example.myviewtest.ui.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myviewtest.ui.fragment.ContentFragment

class TabPageAdapter(private val viewIdList: MutableList<Int>,
                     fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount() = viewIdList.size

    override fun createFragment(position: Int) = ContentFragment.newInstance(viewIdList[position])
}