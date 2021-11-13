package com.example.a7minuteworkout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.a7minuteworkout.R
import kotlinx.android.synthetic.main.fragment_workout.*


class WorkoutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_co.setOnClickListener {
            Navigation.findNavController(it).navigate(
                WorkoutFragmentDirections.actionWorkoutFragmentToStrengthFragment())
        }

    }

}