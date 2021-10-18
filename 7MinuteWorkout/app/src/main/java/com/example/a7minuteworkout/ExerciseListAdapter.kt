package com.example.a7minuteworkout

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_exercise_list_row.view.*
import org.json.JSONArray

class ExerciseListAdapter(val context: Context?, val code:ArrayList<String>,val title:ArrayList<String>,val exerciseArray:JSONArray):
    RecyclerView.Adapter<ExerciseListAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
       val tvExerciseName = view.tvExerciseName
       val ivExerciseImage = view.ivExerciseItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ExerciseListAdapter.ViewHolder {
        return ExerciseListAdapter.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_exercise_list_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExerciseListAdapter.ViewHolder, position: Int) {

        val exerciseCode = code.get(position)
        val exerciseTitle = title.get(position)

        holder.tvExerciseName.text = exerciseTitle

        val uri = Uri.parse("android.resource://com.example.a7minuteworkout/drawable/$exerciseCode")
        holder.ivExerciseImage?.setImageURI(uri)

        holder.tvExerciseName.setOnClickListener {

            Navigation.findNavController(it).navigate(
                ExerciseListFragmentDirections.actionExerciseListFragmentToExerciseDetailFragment(exerciseCode))

        }
    }

    override fun getItemCount(): Int {
       return code.size
    }
}