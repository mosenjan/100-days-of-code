package com.example.a7minuteworkout


import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.navigation.fragment.navArgs
import org.json.JSONObject
import kotlinx.android.synthetic.main.fragment_exercise_detail.*


class ExerciseDetailFragment : Fragment() {

    var code = ""
    var title  = ""
    var strHints = ""
    var strbreathing = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_exercise_detail, container, false)




        // Inflate the layout for this fragment
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ex = ExerciseListFragment()
        val obj = JSONObject(ex.loadJSONFromAsset(requireActivity()))
        val exerciseArray = obj.getJSONArray("exercises")


        val args : ExerciseDetailFragmentArgs by navArgs()

        for (i in 0 until exerciseArray.length()){
            val exerciseDetail = exerciseArray.getJSONObject(i)
            if (exerciseDetail.getString("code") == args.code){
                code = exerciseDetail.getString("code")
                title = exerciseDetail.getString("title")
                val ins = exerciseDetail.getJSONObject("instructions")
                val hints = ins.getJSONArray("hints")
                val breathing = ins.getJSONArray("breathing")

                for (j in 0 until hints.length()){

                    val a : String = hints[j].toString()
                    strHints += getStringByName(a)
                }
                 for (u in 0 until breathing.length()){
                    val b : String = breathing[u].toString()
                    strbreathing += getStringByName(b)
                }

                tvhints.text = strHints
                tvBreathing.text = strbreathing

            }
        }

        tvTitle.text = title


        setUpVideo()


    }


    fun getStringByName(name: String): String {
        return resources.getString(resources.getIdentifier(name, "string", getActivity()?.getPackageName()))
    }


    fun setUpVideo(){
        val view = vView as VideoView
        val path = "android.resource://" + activity!!.packageName + "/raw/" + code
        view.setVideoURI(Uri.parse(path))
        view.start()
        view.setOnCompletionListener { view.start() }


    }
}