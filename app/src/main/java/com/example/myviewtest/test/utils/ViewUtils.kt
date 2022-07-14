package com.example.myviewtest.test.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

object ViewUtils {

    fun dp2px(value: Float, context: Context) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics)

    fun dp2px(value: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, Resources.getSystem().displayMetrics)

}