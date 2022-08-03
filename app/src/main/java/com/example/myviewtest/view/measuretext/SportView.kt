package com.example.myviewtest.view.measuretext

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.example.myviewtest.view.test.utils.dp

private val CIRCLE_COLOR = Color.parseColor("#90A4AE")
private val HIGHLIGHT_COLOR = Color.parseColor("#FF4081")
private val RING_WIDTH = 20.dp
private val RADIUS = 150.dp
class SportView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 50.dp
        textAlign = Paint.Align.CENTER
    }

    private val bounds = Rect()
    private val fontMetrics = Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //绘制环
        paint.style = Paint.Style.STROKE
        paint.color = CIRCLE_COLOR
        paint.strokeWidth = RING_WIDTH
        canvas.drawCircle(width / 2f, height / 2f, RADIUS, paint)

        //绘制进度条
        paint.color = HIGHLIGHT_COLOR
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS,
            height / 2f + RADIUS, -90f, 225f, false, paint)

        //绘制文字(Center)
        paint.style = Paint.Style.FILL

        //静态文字
        paint.getTextBounds("90kmAq", 0, "90kmAq".length, bounds)
        //偏移量
        val offset = (bounds.top + bounds.bottom) / 2f
        canvas.drawText("90kmAq", width / 2f, height / 2f - offset
            , paint)

        /*//动态文字
        paint.getFontMetrics(fontMetrics)
        canvas.drawText("aaqeQA", width / 2f, height / 2f - (fontMetrics.ascent + fontMetrics.descent) / 2f, paint)

        //绘制文字(Left)
        paint.textAlign = Paint.Align.LEFT
        paint.getFontMetrics(fontMetrics)
        canvas.drawText("aaqeQA", 0f, - fontMetrics.top, paint)*/
    }


}