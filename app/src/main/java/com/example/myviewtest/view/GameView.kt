package com.example.myviewtest.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.graphics.alpha
import com.example.myviewtest.view.test.utils.dp

/**
 * Created by ZhangSilong on 2022/8/7.
 */
class GameView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val pathPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 1.dp
        style = Paint.Style.STROKE
        color = Color.parseColor("#1AFB6A35")
    }

    private val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        strokeWidth = 4.dp
        //color = Color.parseColor("#FF9800")
    }

    private val pointPath = Path()
    private val bgPath = Path()

    private val widthX = 132.dp / 6

    var pointY = mutableListOf(30.dp, 20.dp, 30.dp, 20.dp, 40.dp, 30.dp, 40.dp)
        private set(value) {
            field = value
            invalidate()
        }

    private val maxX = 132.dp
    private val maxY = 40.dp

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("GameTimeView", "onMeasure:${width}")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        Log.d("GameTimeView", "onLayout:${width}")
        super.onLayout(changed, left, top, right, bottom)
    }


    override fun onDraw(canvas: Canvas) {
        if (pointY.any { it > 0.dp }) {
            pointPath.reset()
            bgPath.reset()
            repeat(7) {
                if (it == 0) {
                    Log.d("GameTimeView", "width:${width}")
                    Log.d("GameTimeView", "height:${height / 2f - 20.dp}")
                    pointPath.moveTo(
                        width / 2f - 66.dp + it * widthX,
                        height / 2f + 20.dp - pointY[it]
                    )
                    bgPath.moveTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp)
                    bgPath.lineTo(
                        width / 2f - 66.dp + it * widthX,
                        height / 2f + 20.dp - pointY[it]
                    )
                } else {
                    pointPath.lineTo(
                        width / 2f - 66.dp + it * widthX,
                        height / 2f + 20.dp - pointY[it]
                    )
                    bgPath.lineTo(
                        width / 2f - 66.dp + it * widthX,
                        height / 2f + 20.dp - pointY[it]
                    )
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
    }

    //#1AFB6A35
    private fun getShader(): LinearGradient {
        val maxPointY = pointY.maxOf { it }
        val index = pointY.indexOf(maxPointY)
        Log.d("GameTimeView", "height---:${height}")
        return LinearGradient(
            index * widthX, height - maxPointY,
            index * widthX, height / 2f + 20.dp,
            Color.parseColor("#1AFB6A35"),
            Color.parseColor("#00FB6A35"), Shader.TileMode.CLAMP)
    }



}