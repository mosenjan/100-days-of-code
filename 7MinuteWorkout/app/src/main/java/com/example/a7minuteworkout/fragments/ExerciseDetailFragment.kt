package com.example.a7minuteworkout.fragments


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.navigation.fragment.navArgs
import com.example.a7minuteworkout.R
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
        val args : ExerciseDetailFragmentArgs by navArgs()

        code = args.exercise.code
        title = args.exercise.title

        val hints = args.exercise.instructions.hints
        for (i in 0 until hints.size){
            strHints += getStringByName(hints[i])
        }

        val breathing = args.exercise.instructions.breathing
        for (i in 0 until breathing.size){
            strbreathing += getStringByName(breathing[i])
        }

        tvhints.text = strHints
        tvBreathing.text = strbreathing

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