package com.example.a7minuteworkout

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_exercise_list.view.*
import org.json.JSONArray
import java.io.IOException
import java.nio.charset.Charset
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class ExerciseListFragment : Fragment() {

    var code: ArrayList<String> = ArrayList()
    var title: ArrayList<String> = ArrayList()

    lateinit var exerciseArray:JSONArray

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_exercise_list, container, false)

        view.rvExerciseList.layoutManager = LinearLayoutManager(activity)

        try{

            val obj = JSONObject(loadJSONFromAsset(requireActivity()))
            exerciseArray = obj.getJSONArray("exercises")

            for (i in 0 until exerciseArray.length()){
                val exerciseDetail = exerciseArray.getJSONObject(i)
                code.add(exerciseDetail.getString("code"))
                title.add(exerciseDetail.getString("title"))

            }
        }
        catch (e: JSONException){
            e.printStackTrace()
        }

        val exerciseAdapter = ExerciseListAdapter(requireActivity(),code, title, exerciseArray)
        view.rvExerciseList.adapter = exerciseAdapter





        // Inflate the layout for this fragment
        return view
    }

    fun loadJSONFromAsset(context:Context): String {
        val json: String?
        try {
            val inputStream = context.assets.open("exercises_bodyweight.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }


}