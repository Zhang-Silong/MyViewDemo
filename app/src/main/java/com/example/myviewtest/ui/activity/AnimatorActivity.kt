package com.example.myviewtest.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.myviewtest.R
import com.example.myviewtest.ui.adapter.TabPageAdapter
import com.example.myviewtest.databinding.ActivityAnimatorBinding
import com.google.android.material.tabs.TabLayoutMediator

class AnimatorActivity : AppCompatActivity() {

    private lateinit var animatorBinding: ActivityAnimatorBinding
    private lateinit var titleList: MutableList<String>
    private lateinit var viewIdList: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        animatorBinding = ActivityAnimatorBinding.inflate(layoutInflater)
        setContentView(animatorBinding.root)
        titleList = intent.getStringArrayListExtra("title_list")!!
        initViewIdList()
        animatorBinding.viewpager.offscreenPageLimit = viewIdList.size
        val adapter = TabPageAdapter(viewIdList, this)
        animatorBinding.viewpager.adapter = adapter
        TabLayoutMediator(animatorBinding.tabLayout, animatorBinding.viewpager) { tab, position ->
            tab.text = titleList[position]
        }.attach()
        animatorBinding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("AnimatorActivity", "$position")
            }
        })

    }


    private fun initViewIdList() {
        viewIdList = mutableListOf()
        viewIdList.add(R.layout.circle_view)
        viewIdList.add(R.layout.camera_view)
        viewIdList.add(R.layout.point_view)
        viewIdList.add(R.layout.province_view)
        viewIdList.add(R.layout.empty_view)
    }


}