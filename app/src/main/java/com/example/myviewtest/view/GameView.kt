package com.example.myviewtest.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.myviewtest.view.test.utils.dp

/**
 * Created by ZhangSilong on 2022/8/7.
 */
class GameView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 2.dp
        style = Paint.Style.STROKE
        color = Color.parseColor("#FF9800")
    }

    private val pointPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 4.dp
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        color = Color.parseColor("#E91E63")
    }

    private val pathPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 1.dp
        style = Paint.Style.STROKE
        color = Color.parseColor("#FF9800")
    }

    private val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        strokeWidth = 4.dp
        alpha = 1
        color = Color.parseColor("#E91E63")
        //width / 2f - 66.dp + it * widthX, height / 2f + 20.dp
        shader = LinearGradient(width / 2f - 66.dp, height / 2f + 20.dp - one,
            width / 2f - 66.dp + 6 * widthX, height / 2f + 20.dp,
            Color.parseColor("#E91E63"),
            Color.parseColor("#eeeeee"), Shader.TileMode.CLAMP
        )
    }

    private val path = Path()
    private val path1 = Path()

    private val widthX = 132.dp / 6

    var one = 11.dp
        set(value) {
            field = value
            invalidate()
        }
    var two = 12.dp
        set(value) {
            field = value
            invalidate()
        }
    var three = 13.dp
        set(value) {
            field = value
            invalidate()
        }
    var four = 14.dp
        set(value) {
            field = value
            invalidate()
        }
    var five = 15.dp
        set(value) {
            field = value
            invalidate()
        }
    var six = 16.dp
        set(value) {
            field = value
            invalidate()
        }
    var seven = 17.dp
        set(value) {
            field = value
            invalidate()
        }

    private val pointY = mutableListOf<Float>()

    override fun onDraw(canvas: Canvas) {

        canvas.drawRect(width / 2f - 66.dp, height / 2f - 20.dp,
            width / 2f + 66.dp, height / 2f + 20.dp, paint)
        path.reset()
        pointY.clear()
        pointY.add(one)
        pointY.add(two)
        pointY.add(three)
        pointY.add(four)
        pointY.add(five)
        pointY.add(six)
        pointY.add(seven)
        Log.d("GameView", pointY.toString())
        repeat(7) {
            //canvas.drawPoint(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp, pointPaint)
            //canvas.drawPoint(width / 2f - 66.dp + it * widthX, height / 2f - pointY[it], pointPaint)
            if (it == 0) {
                path.moveTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp - pointY[it])
                path1.moveTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp)
                path1.lineTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp - pointY[it])
            } else {
                path.lineTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp - pointY[it])
                path1.lineTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp - pointY[it])
            }
            if (it == 6) {
                path1.lineTo(width / 2f - 66.dp + it * widthX, height / 2f + 20.dp)
            }
        }
        path1.close()
        canvas.drawPath(path, pathPaint)
        canvas.drawPath(path1, bgPaint)

    }


}