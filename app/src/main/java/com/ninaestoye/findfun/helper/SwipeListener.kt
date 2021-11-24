package com.ninaestoye.findfun.helper

import android.content.Context
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

open class SwipeListener(context: Context) : View.OnTouchListener {

    private val TAG = SwipeListener::class.simpleName;
    private val gestureDetector: GestureDetector;

    private val SWIPE_THRESHOLD = 100;
    private val SWIPE_VELOCITY_THRESHOLD = 100;

    init {
        gestureDetector = GestureDetector(context, GestureListener());
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(p1);
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent?): Boolean {
            return true;
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            var result = false;
            e1?.let { horizontal1 ->
                e2?.let { horizontal2 ->
                    val diff = horizontal2.x - horizontal1.x;
                    if (abs(diff) > SWIPE_THRESHOLD && abs(diff) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diff > 0) {
                            onSwipeRight()
                        } else {
                            onSwipeLeft()
                        }
                        result = true;
                    }
                }
            }
            return result;
        }
    }

    open fun onSwipeLeft() {}
    open fun onSwipeRight() {}
}