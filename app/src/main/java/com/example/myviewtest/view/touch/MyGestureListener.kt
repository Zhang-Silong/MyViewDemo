package com.example.myviewtest.view.touch

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent

class MyGestureListener : GestureDetector.OnGestureListener {
    override fun onDown(e: MotionEvent): Boolean {
        //按下屏幕
        Log.d("MyGestureListener", "onDown")
        return false
    }

    override fun onShowPress(e: MotionEvent) {
        //按下一瞬间
        Log.d("MyGestureListener", "onShowPress")
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        //轻按屏幕立即抬起
        Log.d("MyGestureListener", "onSingleTapUp")
        return true
    }

    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        //滑动屏幕
        Log.d("MyGestureListener", "onScroll")
        return true
    }

    override fun onLongPress(e: MotionEvent) {
        //长按屏幕
        Log.d("MyGestureListener", "onLongPress")
    }

    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        //快速滑动屏幕然后松开
        Log.d("MyGestureListener", "onFling")
        return true
    }
}