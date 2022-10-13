package com.example.myviewtest.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myviewtest.R
import com.example.myviewtest.base.Constants
import com.example.myviewtest.view.touch.MyGestureListener
import com.example.myviewtest.view.touch.WaterFallLayout

class CommonTestActivity : AppCompatActivity(), View.OnTouchListener {

    private var gestureDetector: GestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initView() {
        val layoutId = intent.getIntExtra(Constants.LAYOUT_ID, -1)
        setContentView(layoutId)
        when (layoutId) {
            R.layout.layout_gesture -> {
                val gestureText = findViewById<TextView>(R.id.gestureText)
                gestureDetector = GestureDetector(this, MyGestureListener())
                gestureText.setOnTouchListener(this)
            }
            R.layout.layout_flow -> {

            }
            R.layout.layout_water_fall -> {
                val waterFallLayout = findViewById<WaterFallLayout>(R.id.waterFallLayout)
                val addImage = findViewById<Button>(R.id.addImage)
                addImage.setOnClickListener {

                }
            }
        }
    }



    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        gestureDetector?.let {
           return it.onTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }


}