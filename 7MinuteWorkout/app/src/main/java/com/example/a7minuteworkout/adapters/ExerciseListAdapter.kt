package com.example.a7minuteworkout.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minuteworkout.R
import com.example.a7minuteworkout.fragments.ExerciseListFragmentDirections
import com.example.a7minuteworkout.models.Exercises
import kotlinx.android.synthetic.main.item_exercise_list_row.view.*

class ExerciseListAdapter(val context: Context?, val items:ArrayList<Exercises>):
    RecyclerView.Adapter<ExerciseListAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
       val tvExerciseName = view.tvExerciseName
       val ivExerciseImage = view.ivExerciseItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_exercise_list_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val exerciseCode = items[position].code
        val exerciseTitle = items[position].title

        holder.tvExerciseName.text = exerciseTitle

        val uri = Uri.parse("android.resource://com.example.a7minuteworkout/drawable/$exerciseCode")
        holder.ivExerciseImage?.setImageURI(uri)

        holder.tvExerciseName.setOnClickListener {

            Navigation.findNavController(it).navigate(
                ExerciseListFragmentDirections.actionExerciseListFragmentToExerciseDetailFragment(
                    items[position]
                )
            )

        }
    }

    override fun getItemCount(): Int {
       return items.size
    }
}