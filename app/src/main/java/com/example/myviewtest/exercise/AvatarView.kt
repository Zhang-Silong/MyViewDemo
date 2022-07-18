package com.example.myviewtest.exercise

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myviewtest.R
import com.example.myviewtest.test.utils.dp

private val IMAGE_WIDTH = 200f.dp
private val IMAGE_PADDING = 20f.dp
private val X_FERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
class AvatarView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH)

    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(bounds, null)
        canvas.drawOval(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH, paint)
        paint.xfermode = X_FERMODE
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH.toInt()), IMAGE_PADDING, IMAGE_PADDING, paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
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