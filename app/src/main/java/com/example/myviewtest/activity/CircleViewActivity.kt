package com.example.myviewtest.activity

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myviewtest.R
import com.example.myviewtest.propertyanimator.CircleView
import com.example.myviewtest.test.utils.dp

class CircleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_view)
        val circleView = findViewById<CircleView>(R.id.circleView)
        ObjectAnimator.ofFloat(circleView, "radius", 150.dp).apply {
            startDelay = 1000
            start()
        }

    }
}