package com.videodownloader.video.videoplayer.videosaver.drawview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class HeartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint: Paint = Paint().apply {
        color = Color.RED
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val path = Path()

        // Define the heart shape
        val centerX = measuredWidth / 2f
        val centerY = measuredHeight / 2f
        val heartWidth = measuredWidth / 2.5f
        val heartHeight = measuredHeight / 2.5f

        // Move to the starting point
        path.moveTo(centerX, centerY + heartHeight / 2)

        // Draw the left side of the heart
        path.cubicTo(
            centerX - heartWidth / 2, centerY - heartHeight / 4,
            centerX - heartWidth, centerY - heartHeight / 2,
            centerX, centerY - heartHeight
        )

        // Draw the right side of the heart
        path.cubicTo(
            centerX + heartWidth, centerY - heartHeight / 2,
            centerX + heartWidth / 2, centerY - heartHeight / 4,
            centerX, centerY + heartHeight / 2
        )

        // Draw the heart on the canvas
        canvas.drawPath(path, paint)
    }

    // You can add methods to customize the heart color or other attributes
    fun setHeartColor(color: Int) {
        paint.color = color
        invalidate()
    }
}
