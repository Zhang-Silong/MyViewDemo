package com.example.myviewtest.view.measuretext

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.example.myviewtest.R
import com.example.myviewtest.view.test.utils.dp

private val IMAGE_SIZE = 150.dp
private val IMAGE_PADDING = 50.dp
class MultilineTextView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
            "when an unknown printer took a galley of type and scrambled it to make a type specimen " +
            "book. " +
            "It has survived not only five centuries, but also the leap into electronic typesetting, " +
            "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
            "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
            "publishing software like Aldus PageMaker including versions of Lorem Ipsum."

    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
        //textAlign = Paint.Align.LEFT
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
    }

    private val fontMetrics = Paint.FontMetrics()

    private val bitmap = getAvatar(IMAGE_SIZE.toInt())

    override fun onDraw(canvas: Canvas) {
        /*val staticLayout = StaticLayout.Builder.obtain(text, 0, text.length, textPaint, width)
        staticLayout.setIncludePad(false)
        staticLayout.setLineSpacing(0f, 1f)
        staticLayout.build().draw(canvas)*/
        canvas.drawBitmap(bitmap, width - IMAGE_SIZE, IMAGE_PADDING, paint)
        paint.getFontMetrics(fontMetrics)
        val measureWidth = floatArrayOf(0f)
        var start = 0
        var count: Int
        var verticalOffset = - fontMetrics.top
        var maxWidth: Float
        while (start < text.length) {
            maxWidth = if (verticalOffset + fontMetrics.bottom < IMAGE_PADDING ||
                verticalOffset + fontMetrics.top > IMAGE_PADDING + IMAGE_SIZE) {
                width.toFloat()
            } else {
                width.toFloat() - IMAGE_SIZE
            }
            count = paint.breakText(text, start, text.length,true,
                maxWidth, measureWidth)
            canvas.drawText(text, start, start + count, 0f, verticalOffset, paint)
            start += count
            verticalOffset += paint.fontSpacing
        }

    }

    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.test, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.test, options)
    }

}