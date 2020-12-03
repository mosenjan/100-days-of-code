package com.example.mydesign

import android.graphics.drawable.shapes.Shape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SeekBar.OnSeekBarChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mySeekbar1.setOnSeekBarChangeListener(this) //with seek bar change size of circle stroke

    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

        shapes.stroke = p1.toFloat()

    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
} 