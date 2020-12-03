package com.example.mydesign

import android.content.Context
import android.util.AttributeSet
import android.view.View

class MyView(context:Context,attrs:AttributeSet) : View(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {



        
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

}