package com.example.mydesign

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

class Shapes @JvmOverloads constructor (context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {
    var stroke = 5f
    set(value) {
        field = value
        invalidate() //for refresh view when stroke changes
    }

    init {
        //setAnim()

        //for get data from attrs.xml
        val typeArray = context.obtainStyledAttributes(attrs,R.styleable.Shapes)
        stroke  = typeArray.getFloat(R.styleable.Shapes_stroke,5f)
        typeArray.recycle() //for release resource
    }

    override fun draw(canvas: Canvas){
        super.draw(canvas)

        drawCircle(canvas)

    }

    private fun drawLine(canvas: Canvas){
        val w = width.toFloat()
        val h = height.toFloat()

        val paint= Paint()
        paint.color = Color.RED
        paint.strokeWidth = 5f
        paint.style = Paint.Style.STROKE
        canvas.drawLine(0.0f,0.0f,w,h, paint)
    }

    private fun drawCircle(canvas: Canvas){


        val w2 = width.toFloat() / 2f
        val h2 = height.toFloat() / 2f

        val paint= Paint()
        paint.color = Color.RED
        paint.strokeWidth = stroke
        paint.style = Paint.Style.STROKE
        canvas.drawCircle(w2,h2, pixel(60), paint)

    }

    private fun drawRect(canvas: Canvas){
        val paint= Paint()
        paint.color = Color.RED
        paint.strokeWidth = 5f
        paint.style = Paint.Style.STROKE
        canvas.drawRect(1f,1f,pixel(295),pixel(295),paint)
    }

    private fun drawText(canvas: Canvas){

        val paint= Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        paint.textSize = 30f

        val text = "mohsen"
        canvas.drawText(text,0, text.length, pixel(140),pixel(150),paint)
    }

    private fun setAnim(){
        val animator = ValueAnimator.ofFloat(0.0f, 150f)
        animator.interpolator = LinearInterpolator()
        animator.duration = 4000
        animator.repeatCount = ValueAnimator.INFINITE
        animator.addUpdateListener {
           stroke =  it.animatedValue as Float
            invalidate()
        }
        animator.start()
    } //animation for circle stroke

    private fun pixel(dp:Int):Float{
        val scale = resources.displayMetrics.density
        return (scale * dp + 0.5f)
    } //convert dp to pixel
}

