package com.example.myviewtest.view.touch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import kotlin.math.max

class FlowLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        var lineWidth = 0
        var lineHeight = 0
        var width = 0
        var height = 0
        val count = childCount
        Log.d("FlowLayout", count.toString())
        repeat(count) {
            val child = getChildAt(it)
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            val lp = child.layoutParams as MarginLayoutParams
            val childWidth = child.measuredWidth + lp.leftMargin + lp.rightMargin
            val childHeight = child.measuredHeight + lp.topMargin + lp.bottomMargin
            if (lineWidth + childWidth > measureWidth) {
                width = max(lineWidth, childWidth)
                height += lineHeight
                lineHeight = childHeight
                lineWidth = childWidth
            } else {
                lineHeight = max(lineHeight, childHeight)
                lineWidth += childWidth
            }
            if (it == count - 1) {
                height += lineHeight
                width = max(width, lineWidth)
            }
        }
        setMeasuredDimension(resolveSize(width, widthMeasureSpec), resolveSize(height, heightMeasureSpec))
    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val count = childCount
        var lineWidth = 0
        var lineHeight = 0
        var top = 0
        var left = 0
        repeat(count) {
            val child = getChildAt(it)
            val lp = child.layoutParams as MarginLayoutParams
            val childWidth = child.measuredWidth + lp.leftMargin + lp.rightMargin
            val childHeight = child.measuredHeight + lp.topMargin + lp.bottomMargin
            if (childWidth + lineWidth > measuredWidth) {
                top += lineHeight
                left = 0
                lineHeight = childHeight
                lineWidth = childWidth
            } else {
                lineHeight = max(lineHeight, childHeight)
                lineWidth += childWidth
            }
            val lc = left + lp.leftMargin
            val tc = top + lp.topMargin
            val rc = lc + measuredWidth
            val bc = tc + measuredHeight
            child.layout(lc, tc, rc, bc)
            left += childWidth
        }
    }

    override fun generateLayoutParams(p: LayoutParams): LayoutParams {
        return MarginLayoutParams(p)
    }

    override fun generateLayoutParams(attrs: AttributeSet): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }
}