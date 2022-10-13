package com.example.myviewtest.view.touch

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class WaterFallLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private val columns = 3
    private val hSpace = 20
    private val vSpace = 20
    private var childWidth = 0
    private val tops = arrayOf(0, 0, 0)


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        measureChildren(widthMeasureSpec, heightMeasureSpec)
        childWidth = (widthSize - (columns - 1) * hSpace) / columns
        val realWidth = if (childCount < columns) {
            childCount * childWidth + (childCount - 1) * hSpace
        } else {
            widthSize
        }
        clearTop()
        repeat(childCount) {
            val child = getChildAt(it)
            val childHeight = child.measuredHeight * childWidth / child.measuredWidth
            val minColumn = getMinHeightColumn()
            val lp = child.layoutParams as WaterFallLayoutParams
            lp.left = minColumn * (childWidth + hSpace)
            lp.top = tops[minColumn]
            lp.right = lp.left + childWidth
            lp.bottom = lp.top + childHeight
            tops[minColumn] = tops[minColumn].plus(vSpace + childHeight)
        }
        val realHeight = getMaxHeight()
        setMeasuredDimension(resolveSize(realWidth, widthMeasureSpec), resolveSize(realHeight, heightMeasureSpec))
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        clearTop()
        repeat(childCount) {
            val child = getChildAt(it)
            val lp = child.layoutParams as WaterFallLayoutParams
            child.layout(lp.left, lp.top, lp.right, lp.bottom)
        }
    }

    private fun clearTop() {
        repeat(columns) {
            tops[it] = 0
        }
    }

    private fun getMinHeightColumn(): Int {
        var minColumn = 0
        repeat(columns) {
            if (tops[it] < tops[minColumn]) {
                minColumn = it
            }
        }
        return minColumn
    }

    private fun getMaxHeight(): Int {
        var maxHeight = 0
        repeat(columns) {
            if (tops[it] > maxHeight) {
                maxHeight = tops[it]
            }
        }
        return maxHeight
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        repeat(childCount) {
            val index = it
            val view = getChildAt(it)
            view.setOnClickListener {
                listener.onItemClick(view, index)
            }
        }
    }

    override fun checkLayoutParams(p: LayoutParams): Boolean {
        return p is WaterFallLayoutParams
    }

    override fun generateLayoutParams(attrs: AttributeSet): LayoutParams {
        return WaterFallLayoutParams(context, attrs)
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return WaterFallLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
    }

    override fun generateLayoutParams(p: LayoutParams): LayoutParams {
        return WaterFallLayoutParams(p)
    }

    interface OnItemClickListener {
        fun onItemClick(v: View, index: Int)
    }



    class WaterFallLayoutParams : LayoutParams {
        var left = 0
        var top = 0
        var right = 0
        var bottom = 0

        constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
        constructor(width: Int, height: Int) : super(width, height)
        constructor(layoutParams: LayoutParams) : super(layoutParams)
    }


}