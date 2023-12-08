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

class HexagonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint: Paint = Paint().apply {
        color = Color.CYAN
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val path = Path()

        // Define the hexagon points
        val centerX = measuredWidth / 2f
        val centerY = measuredHeight / 2f
        val radius = Math.min(measuredWidth, measuredHeight) / 2f

        for (i in 0 until 6) {
            val angle = Math.toRadians((i * 360 / 6).toDouble())
            val x = centerX + radius * cos(angle).toFloat()
            val y = centerY + radius * sin(angle).toFloat()

            if (i == 0) {
                // Move to the starting point
                path.moveTo(x, y)
            } else {
                // Draw lines to form the hexagon
                path.lineTo(x, y)
            }
        }

        // Close the path to complete the hexagon
        path.close()

        // Draw the hexagon on the canvas
        canvas.drawPath(path, paint)
    }

    // You can add methods to customize the hexagon color or other attributes
    fun setHexagonColor(color: Int) {
        paint.color = color
        invalidate()
    }
}
