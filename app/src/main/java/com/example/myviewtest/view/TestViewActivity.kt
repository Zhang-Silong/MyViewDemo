package com.example.myviewtest.view

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.myviewtest.R

class TestViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_view)
        val moveButton = findViewById<Button>(R.id.moveButton)


        moveButton.setOnClickListener {
            //Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        }
    }

}
