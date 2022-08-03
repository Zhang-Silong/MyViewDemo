package com.example.myviewtest.view.propertyanimator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myviewtest.view.test.utils.dp

class ProvinceView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 50.dp
        textAlign = Paint.Align.CENTER
    }

    var province = "北京市"
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        canvas.drawText(province, width / 2f, height / 2f, paint)
    }

}