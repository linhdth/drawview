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

class StarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint: Paint = Paint().apply {
        color = Color.GREEN
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val path = Path()

        // Define the star points
        val centerX = measuredWidth / 2f
        val centerY = measuredHeight / 2f
        val radiusOuter = Math.min(measuredWidth, measuredHeight) / 2f
        val radiusInner = radiusOuter / 2f

        for (i in 0 until 10) {
            val angle = Math.toRadians((i * 360 / 10).toDouble())
            val radius = if (i % 2 == 0) radiusOuter else radiusInner
            val x = centerX + radius * cos(angle).toFloat()
            val y = centerY + radius * sin(angle).toFloat()

            if (i == 0) {
                // Move to the starting point
                path.moveTo(x, y)
            } else {
                // Draw lines to form the star
                path.lineTo(x, y)
            }
        }

        // Close the path to complete the star
        path.close()

        // Draw the star on the canvas
        canvas.drawPath(path, paint)
    }

    // You can add methods to customize the star color or other attributes
    fun setStarColor(color: Int) {
        paint.color = color
        invalidate()
    }
}
