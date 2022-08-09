package com.example.myviewtest.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myviewtest.databinding.ActivityPropertyAnimatorBinding
import com.example.myviewtest.view.TestActivity
import java.util.ArrayList

class PropertyAnimatorActivity : AppCompatActivity() {
    private lateinit var propertyAnimatorBinding: ActivityPropertyAnimatorBinding
    private lateinit var titleList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        propertyAnimatorBinding = ActivityPropertyAnimatorBinding.inflate(layoutInflater)
        setContentView(propertyAnimatorBinding.root)
        initTitleList()
        propertyAnimatorBinding.circleViewBtn.setOnClickListener {
            Intent(this, AnimatorActivity::class.java).apply {
                putStringArrayListExtra("title_list", titleList as ArrayList<String>)
                startActivity(this)
            }
        }
        propertyAnimatorBinding.avatarViewBtn.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }
    }

    private fun initTitleList() {
        titleList = mutableListOf()
        titleList.add("放缩")
        titleList.add("Camera")
        titleList.add("Point")
        titleList.add("Province")
        titleList.add("测试3")
    }

}