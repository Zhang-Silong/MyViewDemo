package com.example.myviewtest.view.propertyanimator

import android.animation.TypeEvaluator
import com.example.myviewtest.ui.fragment.provinceList

class ProvinceEvaluator : TypeEvaluator<String> {
    override fun evaluate(
        fraction: Float, startValue: String, endValue: String
    ): String {
        val startIndex = provinceList.indexOf(startValue)
        val endIndex = provinceList.indexOf(endValue)
        val currentIndex = startIndex + ((endIndex - startIndex) * fraction).toInt()
        return provinceList[currentIndex]
    }
}