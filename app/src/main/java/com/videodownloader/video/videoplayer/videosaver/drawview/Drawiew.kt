package com.videodownloader.video.videoplayer.videosaver.drawview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class Drawiew(context: Context?) : SurfaceView(context), SurfaceHolder.Callback, Runnable {


    var thread: Thread? = null
    var running = false
    lateinit var canvas: Canvas
    lateinit var paddle: Paddle
    var bounds = Rect()

    var mHolder: SurfaceHolder? = holder

    init {
        if (mHolder != null) {
            mHolder?.addCallback(this)
        }
    }

    private fun setup() {
        paddle = Paddle(this.context, 400f, 1250f, 250f, 28f, 0f)
        var posX: Float = 35f
        var posY: Float = 40f
        val numRows = 8
        val numCols = 6
    }

    fun start() {
        running = true
        thread = Thread(this)
        thread?.start()
    }

    fun stop() {
        running = false
        thread?.join()
    }

    fun update() {

        paddle.update(width.toFloat())
    }

    fun draw() {

        val currentHolder = mHolder ?: return
        canvas = currentHolder.lockCanvas() ?: return

        try {
            canvas.drawColor(Color.BLACK)
            paddle.draw(canvas)
        } finally {
            currentHolder.unlockCanvasAndPost(canvas)
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        if (mHolder != null) {
            mHolder?.addCallback(this)
        }
        setup()
        start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        bounds = Rect(0, 0, width, height)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        stop()
    }

    override fun run() {
        while (running) {
            update()
            draw()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return true
    }
}

class Paddle (context: Context, var posX: Float,var posY:Float,val width: Float = 80f, val height: Float = 28f, var speedX: Float) {

    var bitmap: Bitmap

    init {
        bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.paddle)
    }


    fun update(surfaceWidth: Float) {
        if (posX + bitmap.width < surfaceWidth) {
            posX += speedX
        } else {
            posX = surfaceWidth - bitmap.width.toFloat()
        }
    }

    fun draw(canvas: Canvas){
        val centerX = posX
        val centerY = canvas.height.toFloat() - 80f
        canvas?.drawBitmap(bitmap, centerX, centerY, null)
    }

}