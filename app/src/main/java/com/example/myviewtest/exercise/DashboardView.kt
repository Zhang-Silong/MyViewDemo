package com.example.myviewtest.exercise

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myviewtest.test.utils.px
import kotlin.math.cos
import kotlin.math.sin

private const val OPEN_ANGLE = 120f
private val DASH_WIDTH = 2f.px
private val DASH_LENGTH = 10f.px
private val RADIUS = 150f.px
private val LENGTH = 120f.px
class DashboardView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val dash = Path()
    private val path = Path()
    private lateinit var pathEffect: PathEffect

    init {
        paint.strokeWidth = 3f.px
        paint.style = Paint.Style.STROKE
        dash.addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
        path.addArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS,
            height / 2f + RADIUS, 90 + OPEN_ANGLE / 2f, 360 - OPEN_ANGLE)
        val pathMeasure = PathMeasure(path, false)
        pathEffect = PathDashPathEffect(dash, (pathMeasure.length - DASH_WIDTH) / 20f, 0f, PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {
        //画弧
        canvas.drawPath(path, paint)

        //画刻度
        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)

        //画弧
        paint.pathEffect = null
        canvas.drawLine(width / 2f, height / 2f, width / 2f +
                LENGTH * cos(toRadians()).toFloat(),
        height / 2f + LENGTH * sin(toRadians()).toFloat(), paint)

    }

    private fun toRadians() = Math.toRadians((90 + OPEN_ANGLE / 2f + (360 - OPEN_ANGLE) / 20f * 5).toDouble())

}