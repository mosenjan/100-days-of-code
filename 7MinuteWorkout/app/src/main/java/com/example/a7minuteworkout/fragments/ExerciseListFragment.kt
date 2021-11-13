package com.example.a7minuteworkout.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a7minuteworkout.R
import com.example.a7minuteworkout.adapters.ExerciseListAdapter
import com.example.a7minuteworkout.models.Exercises
import com.example.a7minuteworkout.models.ExercisesModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_exercise_list.view.*
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset


class ExerciseListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_exercise_list, container, false)

        val arg: ExerciseListFragmentArgs by navArgs()

        view.rvExerciseList.layoutManager = LinearLayoutManager(activity)


        try {

            val jsonFileString = getJsonDataFromAsset(requireContext(), "exercises_bodyweight.json")
            var exercises = Gson().fromJson(jsonFileString, ExercisesModel::class.java)

            var exe: ArrayList<Exercises> = ArrayList()
            var i = 0
            when (arg.arg) {
                "upper_body" -> {
                    i = 0
                    while (i < exercises.exercises.size) {
                        if (exercises.exercises[i].category.upper_body > 0) exe.add(exercises.exercises[i])
                        i++
                    }
                }
                "lower_body" -> {
                    i = 0
                    while (i < exercises.exercises.size) {
                        if (exercises.exercises[i].category.lower_body > 0) exe.add(exercises.exercises[i])
                        i++
                    }
                }
                "cardio" -> {
                    i = 0
                    while (i < exercises.exercises.size) {
                        if (exercises.exercises[i].category.cardio > 0) exe.add(exercises.exercises[i])
                        i++
                    }
                }
                "core" -> {
                    i = 0
                    while (i < exercises.exercises.size) {
                        if (exercises.exercises[i].category.core > 0) exe.add(exercises.exercises[i])
                        i++
                    }
                }
                "yoga" -> {
                    i = 0
                    while (i < exercises.exercises.size) {
                        if (exercises.exercises[i].category.yoga > 0) exe.add(exercises.exercises[i])
                        i++
                    }
                }
                "stretching" -> {
                    i = 0
                    while (i < exercises.exercises.size) {
                        if (exercises.exercises[i].category.stretching > 0) exe.add(exercises.exercises[i])
                        i++
                    }
                }
            }


            val itemAdapter = ExerciseListAdapter(requireActivity(), exe)
            view.rvExerciseList.adapter = itemAdapter


        } catch (e: JSONException) {
            e.printStackTrace()
        }

        // Inflate the layout for this fragment
        return view
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        var jsonString: String? = null
        val charset: Charset = Charsets.UTF_8

        try {
            val myUsersJsonFile = context.assets.open(fileName)
            val size = myUsersJsonFile.available()
            val buffer = ByteArray(size)
            myUsersJsonFile.read(buffer)
            myUsersJsonFile.close()
            jsonString = String(buffer, charset)
            //jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }

        return jsonString
    }


}