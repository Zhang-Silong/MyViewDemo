package com.example.myviewtest.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.myviewtest.R
import com.example.myviewtest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.propertyAnimator.setOnClickListener {
            startActivity(Intent(this, PropertyAnimatorActivity::class.java))
        }

        /*val circleView = findViewById<CircleView>(R.id.circleView)
        *//*circleView.animate().apply {
            translationX(100.dp)
            translationY(50.dp)
            duration = 1000
            startDelay = 1000
        }*//*

        ObjectAnimator.ofFloat(circleView, "radius", 150.dp).apply {
            startDelay = 1000
            start()
        }*/
        

    }
}