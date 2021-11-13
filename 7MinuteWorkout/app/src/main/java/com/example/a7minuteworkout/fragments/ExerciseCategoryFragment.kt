package com.example.a7minuteworkout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.a7minuteworkout.R
import kotlinx.android.synthetic.main.fragment_exercise_category.*


class ExerciseCategoryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickHandler()
    }

    fun clickHandler(){
        btn_upperBody.setOnClickListener {
            Navigation.findNavController(it).navigate(ExerciseCategoryFragmentDirections.actionExerciseCategoryFragmentToExerciseListFragment("upper_body"))
        }

        btn_lowerBody.setOnClickListener {
            Navigation.findNavController(it).navigate(ExerciseCategoryFragmentDirections.actionExerciseCategoryFragmentToExerciseListFragment("lower_body"))
        }
        btn_cardio.setOnClickListener {
            Navigation.findNavController(it).navigate(ExerciseCategoryFragmentDirections.actionExerciseCategoryFragmentToExerciseListFragment("cardio"))
        }
        btn_core.setOnClickListener {
            Navigation.findNavController(it).navigate(ExerciseCategoryFragmentDirections.actionExerciseCategoryFragmentToExerciseListFragment("core"))
        }
        btn_stretching.setOnClickListener {
            Navigation.findNavController(it).navigate(ExerciseCategoryFragmentDirections.actionExerciseCategoryFragmentToExerciseListFragment("stretching"))
        }
        btn_yoga.setOnClickListener {
            Navigation.findNavController(it).navigate(ExerciseCategoryFragmentDirections.actionExerciseCategoryFragmentToExerciseListFragment("yoga"))
        }
    }
}