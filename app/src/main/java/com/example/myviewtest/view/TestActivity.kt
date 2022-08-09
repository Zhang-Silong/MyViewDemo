package com.example.myviewtest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myviewtest.R
import com.example.myviewtest.view.test.utils.dp

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val gameView = findViewById<GameView>(R.id.gameView)
        val change = findViewById<Button>(R.id.change)

        change.setOnClickListener {
            gameView.one = 10.dp
            gameView.seven = 10.dp
        }

    }
}