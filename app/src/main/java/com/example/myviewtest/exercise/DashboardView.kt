package com.example.myviewtest.exercise

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myviewtest.test.utils.px

const val OPEN_ANGLE = 120f
val DASH_WIDTH = 2f.px
val DASH_LENGTH = 5f.px
class DashboardView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.strokeWidth = 3f.px
        paint.style = Paint.Style.STROKE
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {

    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawArc(width / 2f - 150f.px, height / 2f - 150f.px, width / 2f + 150f.px,
        height / 2f + 150f.px, 90 + OPEN_ANGLE / 2f, 360 - OPEN_ANGLE, false, paint)
    }

}