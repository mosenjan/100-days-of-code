package com.example.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_b_m_i.*
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setSupportActionBar(toolbar_history_activity)

        val actionbar = supportActionBar
        if (actionbar != null){
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title = "تاریخچه"
        }
        toolbar_history_activity.setNavigationOnClickListener {
            onBackPressed()
            }
        getAllCompletedDates()

    }

    private fun getAllCompletedDates(){
        val dbHandler = sqliteOpenHelper(this,null)
        val allCompletedDateList = dbHandler.getAllCompletedDatesList()

       if (allCompletedDateList.size > 0){
           tvHistory.visibility = View.VISIBLE
           rvHistory.visibility = View.VISIBLE
           tvNoDataAvalable.visibility = View.GONE

           rvHistory.layoutManager = LinearLayoutManager(this)
           val historyAdapter = HistoryAdapter(this, allCompletedDateList)
           rvHistory.adapter = historyAdapter
       }else{
           tvHistory.visibility = View.GONE
           rvHistory.visibility = View.GONE
           tvNoDataAvalable.visibility = View.VISIBLE
       }

    }
}