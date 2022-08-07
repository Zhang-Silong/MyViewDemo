package com.example.myviewtest.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
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

    private val widthX = 130.dp / 6

    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(width / 2f - 65.dp, height / 2f - 24.dp,
            width / 2f + 65.dp, height / 2f + 24.dp, paint)

        for (i in 0 until 7) {
            canvas.drawPoint(width / 2f - 65.dp + i * widthX, height / 2f + 24.dp, pointPaint)
        }


    }


}