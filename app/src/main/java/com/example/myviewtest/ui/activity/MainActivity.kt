package com.example.myviewtest.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myviewtest.R
import com.example.myviewtest.base.Constants
import com.example.myviewtest.databinding.ActivityMainBinding
import com.example.myviewtest.view.TestViewActivity


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.propertyAnimator.setOnClickListener {
            startActivity(Intent(this, PropertyAnimatorActivity::class.java))
        }

        mainBinding.testView.setOnClickListener {
            startActivity(Intent(this, TestViewActivity::class.java))
        }

        mainBinding.gesture.setOnClickListener {
            val intent = Intent(this, CommonTestActivity::class.java)
            intent.putExtra(Constants.LAYOUT_ID, R.layout.layout_gesture)
            startActivity(intent)
        }

        mainBinding.flowLayout.setOnClickListener {
            val intent = Intent(this, CommonTestActivity::class.java)
            intent.putExtra(Constants.LAYOUT_ID, R.layout.layout_flow)
            startActivity(intent)
        }

        mainBinding.waterFallLayout.setOnClickListener {
            val intent = Intent(this, CommonTestActivity::class.java)
            intent.putExtra(Constants.LAYOUT_ID, R.layout.layout_water_fall)
            startActivity(intent)
        }

        mainBinding.rebound.setOnClickListener {
            val intent = Intent(this, CommonTestActivity::class.java)
            intent.putExtra(Constants.LAYOUT_ID, R.layout.layout_rebound)
            startActivity(intent)
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