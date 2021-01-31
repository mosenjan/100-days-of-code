 package com.example.firstproject

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog
import ir.hamsaa.persiandatepicker.util.PersianCalendar
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

 class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {

            datePicker(it)
            //persianDatePicker(it)
        }

    }



    fun persianDatePicker(view: View){

        val initDate = PersianCalendar()
        initDate.setPersianDate(1370, 3, 13)

     var picker = PersianDatePickerDialog(this).setPositiveButtonString("باشه")
             .setNegativeButton("بیخیال")
             .setTodayButton("امروز")
             .setTodayButtonVisible(true)
             .setMinYear(1300)
             .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
             .setInitDate(initDate)
             .setActionTextColor(Color.GRAY)
             //.setTypeFace(typeface)
             .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
             .setShowInBottomSheet(true)
            // .setListener(Listener{}) //TODO: set up Listener later

        picker.show()

    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun datePicker(view: View){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, SelectedYear, SelectedMonth, SelectedDayOfMonth ->

            val selectedDate = "$SelectedDayOfMonth/${SelectedMonth + 1}/$SelectedYear"

            tvSelectedDate.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)

            val selectedDateInMinute = theDate!!.time / 60000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDateInMinutes = currentDate!!.time / 60000

            val differenceInMinutes = currentDateInMinutes - selectedDateInMinute

            tvAgeInMinute.text = differenceInMinutes.toString()


        }, year, month, day).show()
    }
}