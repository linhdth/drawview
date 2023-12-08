package com.videodownloader.video.videoplayer.videosaver.drawview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class PentagonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint: Paint = Paint().apply {
        color = Color.YELLOW
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val path = Path()

        // Define the pentagon points
        val centerX = measuredWidth / 2f
        val centerY = measuredHeight / 2f
        val radius = Math.min(measuredWidth, measuredHeight) / 2f

        for (i in 0 until 5) {
            val angle = Math.toRadians((i * 360 / 5).toDouble())
            val x = centerX + radius * cos(angle).toFloat()
            val y = centerY + radius * sin(angle).toFloat()

            if (i == 0) {
                // Move to the starting point
                path.moveTo(x, y)
            } else {
                // Draw lines to form the pentagon
                path.lineTo(x, y)
            }
        }

        // Close the path to complete the pentagon
        path.close()

        // Draw the pentagon on the canvas
        canvas.drawPath(path, paint)
    }

    // You can add methods to customize the pentagon color or other attributes
    fun setPentagonColor(color: Int) {
        paint.color = color
        invalidate()
    }
}
