package com.videodownloader.video.videoplayer.videosaver.drawview
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class TriangleView @JvmOverloads constructor(
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

        // Define the triangle points
        val centerX = measuredWidth / 2f
        val centerY = measuredHeight / 2f
        val sideLength = Math.min(measuredWidth, measuredHeight) / 2f

        val x1 = centerX
        val y1 = centerY - sideLength / 2f

        val x2 = centerX - sideLength / 2f
        val y2 = centerY + sideLength / 2f

        val x3 = centerX + sideLength / 2f
        val y3 = centerY + sideLength / 2f

        // Move to the starting point
        path.moveTo(x1, y1)

        // Draw lines to form the triangle
        path.lineTo(x2, y2)
        path.lineTo(x3, y3)
        path.lineTo(x1, y1)

        // Close the path to complete the triangle
        path.close()

        // Draw the triangle on the canvas
        canvas.drawPath(path, paint)
    }

    // You can add methods to customize the triangle color or other attributes
    fun setTriangleColor(color: Int) {
        paint.color = color
        invalidate()
    }
}
