package com.example.myviewtest.view.touch

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.ScrollView

class ReboundScrollView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ScrollView(context, attrs) {

    private lateinit var childView: View
    private var preY = 0
    private lateinit var rect: Rect

    override fun onFinishInflate() {
        childView = getChildAt(0)
        super.onFinishInflate()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        val currentY = ev.y
        when (ev.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                rect = Rect(childView.left, childView.top, childView.right, childView.bottom)
            }
            MotionEvent.ACTION_MOVE -> {
                val delta = ((currentY - preY) * 0.25).toInt()
                if (delta > 0) {
                    childView.layout(
                        childView.left,
                        childView.top + delta,
                        childView.right,
                        childView.bottom + delta
                    )
                }
            }
            MotionEvent.ACTION_UP -> {
                val currentTop = childView.top
                childView.layout(rect.left, rect.top, rect.right, rect.bottom)
                val animation = TranslateAnimation(0f, 0f, (currentTop - rect.top).toFloat(), 0f)
                animation.duration = 200
                childView.startAnimation(animation)
            }
        }
        preY = currentY.toInt()
        return super.onTouchEvent(ev)
    }

}