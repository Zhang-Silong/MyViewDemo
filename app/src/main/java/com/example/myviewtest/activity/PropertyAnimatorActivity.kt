package com.example.myviewtest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myviewtest.R
import com.example.myviewtest.databinding.ActivityPropertyAnimatorBinding

class PropertyAnimatorActivity : AppCompatActivity() {
    private lateinit var propertyAnimatorBinding: ActivityPropertyAnimatorBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        propertyAnimatorBinding = ActivityPropertyAnimatorBinding.inflate(layoutInflater)
        setContentView(propertyAnimatorBinding.root)

        propertyAnimatorBinding.circleView.setOnClickListener {
            startActivity(Intent(this, CircleViewActivity::class.java))
        }
        propertyAnimatorBinding.avatarView.setOnClickListener {

        }
    }
}