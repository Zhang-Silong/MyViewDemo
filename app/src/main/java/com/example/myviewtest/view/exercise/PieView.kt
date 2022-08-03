package com.example.myviewtest.view.exercise

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myviewtest.view.test.utils.dp
import kotlin.math.cos
import kotlin.math.sin

private val RADIUS = 150f.dp
private val ANGLE = floatArrayOf(60f, 90f, 150f, 60f)
private val OFFSET_LENGTH = 20f.dp
private val COLORS = intArrayOf(
    Color.parseColor("#C21858"),
    Color.parseColor("#00ACC1"),
    Color.parseColor("#558B2F"),
    Color.parseColor("#5D4037"))
class PieView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.strokeWidth = 3f.dp
    }


    override fun onDraw(canvas: Canvas) {
        var startAngle = 0f
        for ((index, angle) in ANGLE.withIndex()) {
            paint.color = COLORS[index]
            if (index == 0) {
                canvas.save()
                canvas.translate(
                    OFFSET_LENGTH * cos(Math.toRadians(startAngle + angle / 2f.toDouble())).toFloat(),
                OFFSET_LENGTH * sin(Math.toRadians(startAngle + angle / 2f.toDouble())).toFloat())
            }
            canvas.drawArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS,
                height / 2f + RADIUS, startAngle, angle, true, paint)
            startAngle += angle
            if (index == 0) {
                canvas.restore()
            }
        }

    }

}