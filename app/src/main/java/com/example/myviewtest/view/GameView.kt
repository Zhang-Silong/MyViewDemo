package com.example.myviewtest.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myviewtest.view.test.utils.dp

/**
 * Created by ZhangSilong on 2022/8/7.
 */
class GameView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val pathPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 1.dp
        style = Paint.Style.STROKE
        color = Color.parseColor("#FF9800")
    }

    private val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        strokeWidth = 4.dp
        color = Color.parseColor("#E91E63")
    }

    private val pointPath = Path()
    private val bgPath = Path()

    private val widthX = 132.dp / 6

    var pointY = mutableListOf(0.dp, 0.dp, 0.dp, 0.dp, 0.dp, 0.dp, 0.dp)
        private set(value) {
            field = value
            invalidate()
        }

    private val maxX = 132.dp
    private val maxY = 40.dp

    override fun onDraw(canvas: Canvas) {
        pointPath.reset()
        repeat(7) {
            if (it == 0) {
                pointPath.moveTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp - pointY[it])
                bgPath.moveTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp)
                bgPath.lineTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp - pointY[it])
            } else {
                pointPath.lineTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp - pointY[it])
                bgPath.lineTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp - pointY[it])
            }
            if (it == 6) {
                bgPath.lineTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp)
            }
        }
        bgPath.close()
        bgPaint.shader = getShader()
        canvas.drawPath(pointPath, pathPaint)
        canvas.drawPath(bgPath, bgPaint)

    }

    private fun getShader() = LinearGradient(width / 2f - 66.dp, height / 2f + 20.dp - pointY[0],
        width / 2f - 66.dp + 6 * widthX, height / 2f + 20.dp,
        Color.parseColor("#1AFB6A35"),
        Color.parseColor("#00FB6A35"), Shader.TileMode.CLAMP)

    fun judgeTime(time: Float, index: Int) {
        if (time >= 1) {

        }
    }


}