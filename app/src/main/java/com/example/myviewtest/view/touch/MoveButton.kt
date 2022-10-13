package com.example.myviewtest.view.touch

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton

class MoveButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatButton(context, attrs) {

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.rawX
        val y = event.rawY
        val x1 = event.x
        val y1 = event.y
        var lastX = 0f
        var lastY = 0f
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
                Log.d("MoveButton", "lastX:$lastX, lastY:$lastY")
                Log.d("MoveButton", "x1:$x1, y1:$y1")
            }
            MotionEvent.ACTION_MOVE -> {
                val deltaX = x - lastX
                val deltaY = y - lastY
                val nowLeft = (left + deltaX).toInt()
                val nowTop = (top + deltaY).toInt()
                val nowRight = (right + deltaX).toInt()
                val nowBottom = (bottom + deltaY).toInt()
                layout(nowLeft, nowTop, nowRight, nowBottom)
                Log.d("MoveButton", "deltaX:$deltaX, deltaY:$deltaY")
                Log.d("MoveButton", "$nowLeft,$nowTop,$nowRight,$nowBottom")
            }
            MotionEvent.ACTION_UP -> {

            }
        }
        return super.onTouchEvent(event)
    }


}