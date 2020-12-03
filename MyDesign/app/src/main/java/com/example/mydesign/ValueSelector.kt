package com.example.mydesign

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import kotlinx.android.synthetic.main.value_selector.view.*

class ValueSelector(context: Context, attrs: AttributeSet): FrameLayout(context, attrs), View.OnClickListener {

    private val valueNumber: AppCompatTextView
    private val imgPlus: View
    private val imgMinus: View

    private var minValue = 1
    private var maxValue = 10

    init{
        val mainRootView = inflate(context, R.layout.value_selector,this)

        valueNumber = mainRootView.value_number
        imgPlus = mainRootView.imgPlus
        imgMinus = mainRootView.imgMinus

        imgPlus.setOnClickListener(this)
        imgMinus.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.imgPlus -> incrementValue()
            R.id.imgMinus -> decrementValue()
        }
    }

    private fun decrementValue() {
        setValueNumber(getValueNumber() - 1)
    }

    private fun incrementValue() {
        setValueNumber(getValueNumber() + 1)
    }

    private fun getValueNumber(): Int  = valueNumber.text.toString().toInt()

    private fun setValueNumber(number: Int){

        if((number>maxValue) || (number<minValue)) return

        valueNumber.text = number.toString()
    }
}