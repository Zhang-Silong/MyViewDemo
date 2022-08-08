package com.example.myviewtest.view.propertyanimator

import android.animation.TypeEvaluator
import android.graphics.PointF
import android.util.Log
import com.example.myviewtest.view.test.utils.dp

class PointEvaluator : TypeEvaluator<PointF> {

    override fun evaluate(
        fraction: Float,
        startValue: PointF,
        endValue: PointF
    ): PointF {
        val startX = startValue.x
        val endX = endValue.x
        Log.d("PointEvaluator", "x:$startX,y:$endX,start:${100.dp}, end:$endValue")
        val currentX = startX + (endX - startX) * fraction

        val startY = startValue.y
        val endY = endValue.y
        val currentY = startY + (endY - startY) * fraction
        return PointF(currentX, currentY)
    }

}