package com.example.a7minuteworkout.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minuteworkout.R
import com.example.a7minuteworkout.models.Exercises
import kotlinx.android.synthetic.main.item_exercise_prepration_row.view.*


class ExercisePreprationAdapter(val context: Context?, val items:ArrayList<Exercises>):
    RecyclerView.Adapter<ExercisePreprationAdapter.ViewHolder>() {


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvExerciseduration = view.tvExerciseDuration
        val tvExerciseName = view.tvExerciseName
        val ivExerciseImage = view.ivExerciseItem
        val tvExerciseIndex = view.tvExerciseIndex

    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_exercise_prepration_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exerciseDuration = items[position].duration
        val exerciseCode = items[position].code
        val exerciseTitle = items[position].title

        holder.tvExerciseduration.text = exerciseDuration.toString()
        holder.tvExerciseName.text = exerciseTitle
        holder.tvExerciseIndex.text = position.toString()

        val uri = Uri.parse("android.resource://com.example.a7minuteworkout/drawable/$exerciseCode")
        holder.ivExerciseImage?.setImageURI(uri)
    }

    override fun getItemCount(): Int {
     return  items.size
    }
}