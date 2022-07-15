package com.example.myviewtest.test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View

import com.example.myviewtest.test.utils.px

class TestView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()

    //view尺寸发生改变时回调
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        //super.onSizeChanged()
        Log.d("TestView", "onSizeChanged:$w, $h, $oldw, $oldh")
        path.reset()
        //CW:顺时针，CCW：逆时针
       path.addCircle(width / 2f, height / 2f + 300f, 50f.px, Path.Direction.CCW )
       path.addRect(width / 2f - 50f.px, height / 2f + 300f, width / 2f + 50f.px, height / 2f + 300f + 2 * 50f.px, Path.Direction.CW)

    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(100f, 100f, 200f, 200f, paint)
        canvas.drawCircle(width / 2f, height / 2f, 50f.px, paint)
        canvas.drawPath(path, paint)
    }
}