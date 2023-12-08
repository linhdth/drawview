package com.videodownloader.video.videoplayer.videosaver.drawview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint: Paint = Paint().apply {
        color = Color.BLUE
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val viewWidthHalf = measuredWidth / 2f
        val viewHeightHalf = measuredHeight / 2f

        val radius = Math.min(viewWidthHalf, viewHeightHalf)

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, paint)
    }

    // You can add methods to customize the circle color or other attributes
    fun setCircleColor(color: Int) {
        paint.color = color
        invalidate()
    }
}