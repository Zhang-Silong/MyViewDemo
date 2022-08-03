package com.example.myviewtest.view.propertyanimator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myviewtest.view.test.utils.dp

class CircleView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var radius = 50.dp
    set(value) {
        field = value
        invalidate()
    }

    init {
        paint.color = Color.parseColor("#E91E63")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width / 2f, height / 2f, radius, paint)
    }

}