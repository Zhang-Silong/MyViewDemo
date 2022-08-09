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
        var t = 10.dp
        change.setOnClickListener {

            /*repeat(7) {
                gameView.pointY[it] = t
                t += 1.dp
            }
            gameView.invalidate()*/
            gameView.pointY[0] = 10.dp
            gameView.pointY[1] = 21.dp
            gameView.pointY[2] = 12.dp
            gameView.pointY[3] = 15.dp
            gameView.pointY[4] = 23.dp
            gameView.pointY[5] = 30.dp
            gameView.pointY[6] = 36.dp
            gameView.invalidate()
        }

    }
}