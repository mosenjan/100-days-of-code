package com.example.a7minuteworkout.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a7minuteworkout.R
import com.example.a7minuteworkout.adapters.ExercisePreprationAdapter
import com.example.a7minuteworkout.models.Exercises
import com.example.a7minuteworkout.models.ExercisesModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_exercise_prepration.view.*


class ExercisePreprationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_exercise_prepration, container, false)

        view.rvExercisePrepration.layoutManager = LinearLayoutManager(activity)

        val arg : ExercisePreprationFragmentArgs by navArgs()

        //get json data from file
        val ex  = ExerciseListFragment()
        val jsonfileString = ex.getJsonDataFromAsset(requireContext(), "exercises_bodyweight.json")
        val exercises = Gson().fromJson(jsonfileString,ExercisesModel::class.java)

        var exe: ArrayList<Exercises> = ArrayList()

        //create custom list of exercise by program
        for (i in 0 until exercises.exercises.size){
            if (exercises.exercises[i].sets.a_upper_body.suitability > 0)
                exe.add(exercises.exercises[i])
        }

        //add rest time for each exercise
        for (i in 0 until exe.size){
            if (exe[i].change_sides == true) {
                exe[i].duration += 15
            }else{
                exe[i].duration += 10
            }
        }

        //shuffle list
        exe.shuffle()

        val program : ArrayList<Exercises> = ArrayList()
        var timeLimit :Long = 200 // set by user
        var timeSum :Long = 0

        loop@ for (i in 0 until exe.size){
            if (timeSum>timeLimit) break@loop
            timeSum += exe[i].duration
            program.add(exe[i])
        }



        val itemExercise = ExercisePreprationAdapter(requireActivity(),program)
        view.rvExercisePrepration.adapter = itemExercise

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}